package com.nabilbdev.fes.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nabilbdev.fes.R
import com.nabilbdev.fes.data.model.Recommendation
import com.nabilbdev.fes.ui.navigation.FesAppScreens
import com.nabilbdev.fes.ui.navigation.navItemList
import com.nabilbdev.fes.ui.screens.bars.FesTopAppBar
import com.nabilbdev.fes.ui.screens.bars.NavRail
import com.nabilbdev.fes.ui.screens.category.HotelCategoryScreen
import com.nabilbdev.fes.ui.screens.category.LandmarkCategoryScreen
import com.nabilbdev.fes.ui.screens.category.RestaurantCategoryScreen
import com.nabilbdev.fes.ui.screens.feed.FeedScreen
import com.nabilbdev.fes.ui.screens.recommendation.RecommendationScreen
import com.nabilbdev.fes.ui.utils.FesNavigationType
import com.nabilbdev.fes.ui.viewmodel.FesViewModel

@Composable
fun FesApp(
    windowSize: WindowWidthSizeClass
) {

    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = backStackEntry?.destination?.route ?: FesAppScreens.Feed.title

    val viewModel: FesViewModel = viewModel()
    val fesUiState by viewModel.uiState.collectAsState()
    val currentRecommendation = fesUiState.currentSelectedRecommendation

    // setting navigation type based on screen size.
    val navigationType = when (windowSize) {
        WindowWidthSizeClass.Compact -> FesNavigationType.BOTTOM_NAVIGATION
        WindowWidthSizeClass.Medium -> FesNavigationType.NAVIGATION_RAIL
        WindowWidthSizeClass.Expanded -> FesNavigationType.SPLIT_NAV_RAIL
        else -> FesNavigationType.BOTTOM_NAVIGATION
    }

    Scaffold(
        topBar = {
            if (navigationType == FesNavigationType.BOTTOM_NAVIGATION) {
                FesTopAppBar(
                    currentScreen = currentScreen
                )
            }
        },
        bottomBar = {
            if (navigationType == FesNavigationType.BOTTOM_NAVIGATION) {
                NavigationBar(
                    containerColor = Color.White,
                    tonalElevation = dimensionResource(id = R.dimen.padding_default)
                ) {

                    navItemList.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = viewModel.isSelectingBottomNavItem(index),
                            onClick = {
                                viewModel
                                    .pickBottomNavItemAndUpdateGridListScreens(
                                        index = index,
                                        categoryOptions = item.route.uppercase()
                                    )
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = {
                                Box(
                                    modifier = Modifier
                                        .size(dimensionResource(id = R.dimen.icon_border_size))
                                        .clip(CircleShape)
                                        .background(
                                            color = when (viewModel.isSelectingBottomNavItem(
                                                index
                                            )) {
                                                true -> Color.Black
                                                else -> Color.Transparent
                                            },
                                        ), contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        painter = painterResource(id = item.icon),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(dimensionResource(id = R.dimen.icon_size))
                                            .padding(dimensionResource(id = R.dimen.padding_small))
                                    )
                                }
                            },
                            colors = NavigationBarItemColors(
                                selectedIconColor = Color.White,
                                unselectedIconColor = Color.Black,
                                selectedIndicatorColor = Color.Transparent,
                                selectedTextColor = Color.Transparent,
                                unselectedTextColor = Color.Transparent,
                                disabledIconColor = Color.Transparent,
                                disabledTextColor = Color.Transparent
                            )
                        )

                    }
                }
            }
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = currentScreen,
            modifier = when (navigationType) {
                FesNavigationType.NAVIGATION_RAIL, FesNavigationType.SPLIT_NAV_RAIL -> Modifier.padding(
                    start = 95.dp
                )

                else -> Modifier.padding(0.dp)
            },
        ) {
            composable(route = FesAppScreens.Feed.title) {
                FeedScreen(
                    listByCategory = fesUiState.recommendationLists.entries.toList(),
                    onRecommendationCardPressed = { recommendation: Recommendation ->
                        viewModel.updateAndSelectDetailScreen(recommendation)
                    },
                    contentPadding = innerPadding
                )
            }
            composable(route = FesAppScreens.Landmark.title) {
                LandmarkCategoryScreen(
                    landmarksList = fesUiState.currentRecommendationList,
                    onRecommendationCardPressed = { recommendation: Recommendation ->
                        viewModel.updateAndSelectDetailScreen(recommendation)
                    },
                    contentPadding = innerPadding
                )
            }
            composable(route = FesAppScreens.Restaurant.title) {
                RestaurantCategoryScreen(
                    restaurantsList = fesUiState.currentRecommendationList,
                    onRecommendationCardPressed = { recommendation: Recommendation ->
                        viewModel.updateAndSelectDetailScreen(recommendation)
                    },
                    contentPadding = innerPadding
                )
            }
            composable(route = FesAppScreens.Hotel.title) {
                HotelCategoryScreen(
                    hotelsList = fesUiState.currentRecommendationList,
                    onRecommendationCardPressed = { recommendation: Recommendation ->
                        viewModel.updateAndSelectDetailScreen(recommendation)
                    },
                    contentPadding = innerPadding
                )
            }
        }
    }


    if (!fesUiState.isShowingFeed) {
        RecommendationScreen(
            recommendation = currentRecommendation,
            onBackButtonClicked = {
                viewModel.hideDetailScreen()
            },
            stars = viewModel.updateReviewStars(recommendation = currentRecommendation),
            navigationType = navigationType
        )
        BackHandler(
            enabled = true,
            onBack = {
                viewModel.hideDetailScreen()
            }
        )
    }

    // Navigation behaviour or the app
    when (navigationType) {

        FesNavigationType.NAVIGATION_RAIL, FesNavigationType.SPLIT_NAV_RAIL -> {
            NavigationRail(
                containerColor = Color.White,
                modifier = Modifier
                    .wrapContentWidth(align = Alignment.Start)
                    .background(MaterialTheme.colorScheme.inverseOnSurface)
                    .offset((-1).dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .verticalScroll(rememberScrollState())
                ) {
                    navItemList.forEachIndexed { index, item ->
                        NavRail(
                            selected = viewModel.isSelectingBottomNavItem(index),
                            onNavItemClicked = {
                                viewModel.hideDetailScreen()
                                viewModel
                                    .pickBottomNavItemAndUpdateGridListScreens(
                                        index = index,
                                        categoryOptions = item.route.uppercase()
                                    )
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = painterResource(id = item.icon),
                            label = item.label
                        )
                    }
                }
            }
        }

        else -> {
            // Code is not reaching here.
        }
    }
}
package com.nabilbdev.fes.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Place
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.vector.ImageVector

@Stable
data class BottomNavItem(
    val route: String,
    val icon: ImageVector
)

val navItemList = listOf(
    BottomNavItem(
        route = FesAppScreens.Feed.title,
        icon = Icons.Rounded.Menu
    ),
    BottomNavItem(
        route = FesAppScreens.Landmark.title,
        icon = Icons.Rounded.Place,
    ),
    BottomNavItem(
        route = FesAppScreens.Hotel.title,
        icon = Icons.Rounded.Home,
    ),
    BottomNavItem(
        route = FesAppScreens.Restaurant.title,
        icon = Icons.Rounded.Face,
    )
)
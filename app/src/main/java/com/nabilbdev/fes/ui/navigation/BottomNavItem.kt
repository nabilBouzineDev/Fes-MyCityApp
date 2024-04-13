package com.nabilbdev.fes.ui.navigation

import androidx.compose.runtime.Stable
import com.nabilbdev.fes.R

@Stable
data class BottomNavItem(
    val route: String,
    val label: String,
    val icon: Int
)

val navItemList = listOf(
    BottomNavItem(
        route = FesAppScreens.Feed.title,
        label = "Home",
        icon = R.drawable.feed
    ),
    BottomNavItem(
        route = FesAppScreens.Landmark.title,
        label = "Land",
        icon = R.drawable.emoji_flags,
    ),
    BottomNavItem(
        route = FesAppScreens.Hotel.title,
        label = "Hotel",
        icon = R.drawable.hotel,
    ),
    BottomNavItem(
        route = FesAppScreens.Restaurant.title,
        label = "Resto",
        icon = R.drawable.restaurant,
    )
)
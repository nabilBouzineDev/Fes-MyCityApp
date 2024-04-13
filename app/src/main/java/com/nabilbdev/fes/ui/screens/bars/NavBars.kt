package com.nabilbdev.fes.ui.screens.bars

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import com.nabilbdev.fes.R

@Composable
fun NavRail(
    selected: Boolean,
    onNavItemClicked: () -> Unit,
    icon: Painter,
    label: String,
    modifier: Modifier = Modifier
) {

    NavigationRailItem(
        selected = selected,
        onClick = onNavItemClicked,
        icon = {
            Box(
                modifier = modifier
                    .size(dimensionResource(id = R.dimen.icon_border_size))
                    .clip(CircleShape)
                    .background(
                        color = when (selected) {
                            true -> Color.Black
                            else -> Color.Transparent
                        },
                    ),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    painter = icon,
                    contentDescription = null,
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.icon_size))
                        .padding(dimensionResource(id = R.dimen.padding_small))
                )
            }
        },
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.bodySmall,
                color = if (selected) Color.Black else Color.Transparent,
                modifier = Modifier.padding(
                    bottom = dimensionResource(id = R.dimen.padding_very_small)
                )
            )
        },
        colors = NavigationRailItemColors(
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

@Composable
fun PermanentNavDrawer(
    selected: Boolean,
    onNavItemClicked: () -> Unit,
    icon: Painter,
    label: String,
    modifier: Modifier = Modifier
) {
    NavigationDrawerItem(
        selected = selected,
        onClick = onNavItemClicked,
        icon = {
            Box(
                modifier = modifier
                    .size(dimensionResource(id = R.dimen.icon_border_size))
                    .clip(CircleShape)
                    .background(
                        color = when (selected) {
                            true -> Color.Black
                            else -> Color.Transparent
                        },
                    ), contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = icon,
                    contentDescription = null,
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.icon_size))
                        .padding(dimensionResource(id = R.dimen.padding_small))
                )
            }
        },
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                modifier = Modifier.padding(
                    bottom = dimensionResource(id = R.dimen.padding_very_small)
                )
            )
        },
        colors = NavigationDrawerItemDefaults.colors(
            selectedIconColor = Color.White,
            unselectedIconColor = Color.Black,
            selectedTextColor = Color.Transparent,
            unselectedTextColor = Color.Transparent,
        )
    )
}


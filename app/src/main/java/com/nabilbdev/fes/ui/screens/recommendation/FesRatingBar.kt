package com.nabilbdev.fes.ui.screens.recommendation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.nabilbdev.fes.R

@Composable
fun FesRatingBar(
    stars: Int,
    color: Color,
    isCompact: Boolean,
    size: Dp,
    modifier: Modifier = Modifier
) {
    if (isCompact) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    start = dimensionResource(id = R.dimen.padding_large),
                    end = dimensionResource(id = R.dimen.padding_large),
                    top = dimensionResource(id = R.dimen.padding_medium)
                )
        ) {
            Text(
                text = stringResource(id = R.string.review_by_google),
                color = color,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontFamily = FontFamily.Serif,
                    fontSize = 20.sp
                ),
                modifier = Modifier.align(Alignment.CenterStart)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
            ) {
                for (star in 0 until 5) {
                    if (star < stars) {
                        Icon(
                            contentDescription = null,
                            tint = color,
                            imageVector = Icons.Filled.Star,
                            modifier = Modifier.size(size)
                        )
                    } else {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_empty_star),
                            tint = color,
                            contentDescription = null,
                            modifier = Modifier.size(size)
                        )
                    }
                }
            }
        }
    } else {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_medium))
        ) {
            for (star in 0 until 5) {
                if (star < stars) {
                    Icon(
                        contentDescription = null,
                        tint = color,
                        imageVector = Icons.Filled.Star,
                        modifier = Modifier.size(size)
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_empty_star),
                        tint = color,
                        contentDescription = null,
                        modifier = Modifier.size(size)
                    )
                }
            }
        }
    }
}
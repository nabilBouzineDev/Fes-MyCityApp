package com.nabilbdev.fes.ui.screens.recommendation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import com.nabilbdev.fes.R

@Composable
fun FesRatingBar(
    stars: Int,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .wrapContentWidth()
    ) {
        Text(
            text = stringResource(id = R.string.review_by_google),
            textAlign = TextAlign.Left,
            fontStyle = FontStyle.Italic,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(
                    start = dimensionResource(id = R.dimen.padding_small),
                    end = dimensionResource(id = R.dimen.padding_medium)
                )
        )
        for (star in 0 until 5) {
            if (star < stars) {
                Icon(
                    contentDescription = null,
                    imageVector = Icons.Filled.Star
                )
            } else {
                Icon(
                    painter = painterResource(id = R.drawable.ic_empty_star),
                    contentDescription = null
                )
            }
        }
    }
}
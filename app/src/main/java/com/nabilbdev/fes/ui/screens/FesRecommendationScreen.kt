package com.nabilbdev.fes.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.nabilbdev.fes.R
import com.nabilbdev.fes.data.DataSourceProvider
import com.nabilbdev.fes.data.model.Recommendation

@Composable
fun RecommendationScreen(
    recommendation: Recommendation,
    onBackButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RectangleShape,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier.fillMaxSize()
    ) {
        Box {
            Image(
                painter = painterResource(id = recommendation.imageResourceId),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                colorFilter = ColorFilter.tint(
                    color = MaterialTheme.colorScheme.primary.copy(0.8f),
                    blendMode = BlendMode.Darken
                ),
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
            )
            BackIconButtonAndPlaceName(
                recommendation = recommendation,
                onBackButtonClicked = onBackButtonClicked
            )
        }
        ReviewAndDescription(
            recommendation = recommendation
        )
    }
}

@Composable
fun BackIconButtonAndPlaceName(
    recommendation: Recommendation,
    onBackButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(dimensionResource(id = R.dimen.padding_small))) {
        IconButton(
            onClick = onBackButtonClicked,
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
        Text(
            text = recommendation.name,
            color = MaterialTheme.colorScheme.onPrimary,
            fontStyle = FontStyle.Italic,
            style = MaterialTheme.typography.headlineLarge.copy(
                lineBreak = LineBreak.Heading
            ),
            modifier = Modifier
                .padding(
                    start = dimensionResource(id = R.dimen.padding_large)
                )
        )
    }
}

@Composable
fun ReviewAndDescription(
    recommendation: Recommendation,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(dimensionResource(id = R.dimen.padding_large))) {

        /**
         * TODO("Don't forget ot your custom reviews")
         */
        /*Icon(
            imageVector = Icons.Outlined.Star,
            tint = MaterialTheme.colorScheme.primaryContainer,
            contentDescription = null,
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.icon_Size))
                .padding(bottom = dimensionResource(id = R.dimen.padding_medium))
        )*/
        Text(
            text = recommendation.description,
            color = MaterialTheme.colorScheme.onPrimary,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(start = dimensionResource(id = R.dimen.padding_medium))
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun RecommendationScreenPreview() {
    RecommendationScreen(
        recommendation = DataSourceProvider.allRecommendations[0],
        onBackButtonClicked = {}
    )
}
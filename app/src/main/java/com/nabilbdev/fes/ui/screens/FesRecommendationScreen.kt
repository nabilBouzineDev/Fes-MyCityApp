package com.nabilbdev.fes.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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
import com.nabilbdev.fes.ui.theme.FesTheme

@Composable
fun RecommendationScreen(
    recommendation: Recommendation,
    onBackButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {

    Card(
        shape = RectangleShape,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiary
        ),
        modifier = modifier.fillMaxSize()
    ) {
        Box {
            Image(
                painter = painterResource(id = recommendation.imageResourceId),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                colorFilter = ColorFilter.tint(
                    color = MaterialTheme.colorScheme.tertiary.copy(0.8f),
                    blendMode = BlendMode.Darken
                ),
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
            )
            BackIconButtonAndPlaceName(
                recommendation = recommendation,
                onBackButtonClicked = onBackButtonClicked,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
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
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Black,
                        Color.Transparent
                    )
                )
            )
    ) {
        Column(modifier = modifier) {
            IconButton(
                onClick = onBackButtonClicked
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowDown,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Text(
                text = recommendation.name,
                fontStyle = FontStyle.Italic,
                color = Color.White,
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
}

@Composable
fun ReviewAndDescription(
    recommendation: Recommendation,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.padding_large))
    ) {
        Icon(
            imageVector = Icons.Outlined.Star,
            tint = MaterialTheme.colorScheme.tertiaryContainer,
            contentDescription = null,
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.icon_Size))
                .padding(bottom = dimensionResource(id = R.dimen.padding_medium))
        )
        Text(
            text = recommendation.description,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(start = dimensionResource(id = R.dimen.padding_medium))
        )
    }
}

@Preview
@Composable
fun RecommendationScreenPreview() {
    FesTheme {
        RecommendationScreen(
            recommendation = DataSourceProvider.allRecommendations[1],
            onBackButtonClicked = {}
        )
    }
}

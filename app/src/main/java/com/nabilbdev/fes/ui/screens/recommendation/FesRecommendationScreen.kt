package com.nabilbdev.fes.ui.screens.recommendation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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
    stars: Int,
    modifier: Modifier = Modifier
) {

    Card(
        shape = RectangleShape,
        modifier = modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
        ) {
            Image(
                painter = painterResource(id = recommendation.imageResourceId),
                contentDescription = null,
                alpha = 0.5f,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
            )
            BackIconButtonAndPlaceName(
                recommendation = recommendation,
                onBackButtonClicked = onBackButtonClicked,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        ReviewAndDescription(
            recommendation = recommendation,
            stars = stars,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun BackIconButtonAndPlaceName(
    recommendation: Recommendation,
    onBackButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Black,
                        Color.Transparent
                    )
                )
            )
    ) {
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

@Composable
fun ReviewAndDescription(
    recommendation: Recommendation,
    stars: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.padding_large))
    ) {
        Card(
            shape = MaterialTheme.shapes.small,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.tertiary
            ),
            modifier = Modifier
                .padding(
                    bottom = dimensionResource(id = R.dimen.padding_medium)
                )
                .fillMaxWidth()
                .align(Alignment.Start)
        ) {
            FesRatingBar(
                stars = stars,
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_small))
            )
        }
        Text(
            text = recommendation.description,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .padding(
                    start = dimensionResource(id = R.dimen.padding_large)
                )
        )
    }
}

@Preview(apiLevel = 33)
@Composable
fun RecommendationScreenPreview() {
    FesTheme {
        RecommendationScreen(
            recommendation = DataSourceProvider.allRecommendations[1],
            onBackButtonClicked = {},
            stars = 0
        )
    }
}
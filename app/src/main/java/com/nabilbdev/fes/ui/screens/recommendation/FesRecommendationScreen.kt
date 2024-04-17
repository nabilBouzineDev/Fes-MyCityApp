package com.nabilbdev.fes.ui.screens.recommendation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.unit.dp
import com.nabilbdev.fes.R
import com.nabilbdev.fes.data.DataSourceProvider
import com.nabilbdev.fes.data.model.Recommendation
import com.nabilbdev.fes.ui.theme.FesTheme
import com.nabilbdev.fes.ui.utils.FesNavigationType

@Composable
fun RecommendationScreen(
    recommendation: Recommendation,
    onBackButtonClicked: () -> Unit,
    stars: Int,
    navigationType: FesNavigationType,
    modifier: Modifier = Modifier
) {

    Card(
        shape = RectangleShape,
        modifier = if (navigationType == FesNavigationType.NAVIGATION_RAIL ||
            navigationType == FesNavigationType.SPLIT_NAV_RAIL
        ) {
            modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(start = 95.dp)
        } else {
            modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        }
    ) {
        ImageAndHeader(
            recommendation = recommendation,
            onBackButtonClicked = onBackButtonClicked
        )
        ReviewAndDescription(
            recommendation = recommendation,
            stars = stars,
        )
    }
}

@Composable
fun ImageAndHeader(
    recommendation: Recommendation,
    onBackButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box {
        Image(
            painter = painterResource(id = recommendation.imageResourceId),
            contentDescription = null,
            alpha = 0.5f,
            modifier = modifier
                .fillMaxWidth()
                .size(dimensionResource(id = R.dimen.recommendation_image_size)),
            contentScale = ContentScale.Crop
        )
        BackIconButtonAndPlaceName(
            recommendation = recommendation,
            onBackButtonClicked = onBackButtonClicked,
            modifier = Modifier
                .fillMaxWidth()
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

@Preview(apiLevel = 33, showSystemUi = true)
@Composable
fun RecommendationScreenPreview() {
    FesTheme {
        RecommendationScreen(
            recommendation = DataSourceProvider.allRecommendations[7],
            onBackButtonClicked = {},
            stars = 2,
            navigationType = FesNavigationType.BOTTOM_NAVIGATION
        )
    }
}
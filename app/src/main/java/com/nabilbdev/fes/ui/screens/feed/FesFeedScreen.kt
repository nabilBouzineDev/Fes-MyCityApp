package com.nabilbdev.fes.ui.screens.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineBreak
import com.nabilbdev.fes.R
import com.nabilbdev.fes.data.model.CategoryOptions
import com.nabilbdev.fes.data.model.Recommendation
import com.nabilbdev.fes.ui.screens.bars.FesTopBanner

@Composable
fun FeedScreen(
    listByCategory: List<Map.Entry<CategoryOptions, List<Recommendation>>>,
    onRecommendationCardPressed: (Recommendation) -> Unit,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .padding(contentPadding)
            .verticalScroll(rememberScrollState())
    ) {

        FesTopBanner()
        listByCategory.forEach {
            RecommendationsVerticalColumn(
                categoryOption = it.key,
                categoryListSize = it.value.size,
                recommendationList = it.value,
                onRecommendationCardPressed = onRecommendationCardPressed
            )
        }
    }
}

@Composable
fun RecommendationsVerticalColumn(
    categoryOption: CategoryOptions,
    categoryListSize: Int,
    recommendationList: List<Recommendation>,
    onRecommendationCardPressed: (Recommendation) -> Unit,
    modifier: Modifier = Modifier
) {
    CategoryTitle(
        categoryOption = categoryOption,
        numberOfPlaces = categoryListSize,
        modifier = modifier
            .padding(top = dimensionResource(id = R.dimen.padding_medium))
    )
    RecommendationHorizontalList(
        recommendationList = recommendationList,
        onRecommendationCardPressed = onRecommendationCardPressed
    )
}

@Composable
fun RecommendationHorizontalList(
    recommendationList: List<Recommendation>,
    onRecommendationCardPressed: (Recommendation) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .horizontalScroll(rememberScrollState())
    ) {
        recommendationList.forEach {
            RecommendationCard(
                recommendation = it,
                onCardClick = { onRecommendationCardPressed(it) },
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_small))
            )

        }
    }
}

@Composable
fun CategoryTitle(
    categoryOption: CategoryOptions,
    numberOfPlaces: Int,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(
                dimensionResource(id = R.dimen.padding_small)
            )

    ) {
        Text(
            text = categoryOption.name,
            softWrap = true,
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "$numberOfPlaces Places",
            softWrap = true,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun RecommendationCard(
    recommendation: Recommendation,
    onCardClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
            .size(
                height = dimensionResource(id = R.dimen.image_height),
                width = dimensionResource(id = R.dimen.image_width)
            ),
        onClick = onCardClick
    ) {
        ImageCard(
            recommendation = recommendation
        )
    }
}

@Composable
fun ImageCard(
    modifier: Modifier = Modifier,
    recommendation: Recommendation
) {
    Box(
        contentAlignment = Alignment.BottomStart,
    ) {
        Image(
            painter = painterResource(id = recommendation.imageResourceId),
            contentDescription = null,
            modifier = modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )
        Text(
            text = recommendation.name,
            color = Color.White,
            softWrap = true,
            style = MaterialTheme.typography.bodyMedium.copy(
                lineBreak = LineBreak.Simple
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        )
                    )
                )
                .padding(dimensionResource(id = R.dimen.padding_small))
        )
    }
}
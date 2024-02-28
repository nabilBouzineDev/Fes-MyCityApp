package com.nabilbdev.fes.ui.screens.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
import com.nabilbdev.fes.ui.viewmodel.FesUiState

@Composable
fun FeedScreen(
    fesUiState: FesUiState,
    categoryUpdater: (CategoryOptions) -> CategoryOptions,
    onRecommendationCardPressed: (Recommendation) -> Unit,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {

    val categoriesLists = remember {
        listOf(
            CategoryOptions.LANDMARKS,
            CategoryOptions.HOTELS,
            CategoryOptions.RESTAURANTS
        )
    }


    LazyColumn(contentPadding = contentPadding){

        item {
            FesTopBanner(
                contentPadding = PaddingValues(
                    start = dimensionResource(id = R.dimen.padding_small),
                    top = dimensionResource(id = R.dimen.padding_medium),
                    end = dimensionResource(id = R.dimen.padding_small),
                    bottom = dimensionResource(id = R.dimen.padding_medium)
                )
            )
        }

        categoriesLists.forEach {
            item {
                CategoryTitle(
                    categoryOption = it,
                    numberOfPlaces =
                        fesUiState.recommendationLists[categoryUpdater.invoke(it)]!!.size,
                    modifier = modifier
                        .padding(top = dimensionResource(id = R.dimen.padding_medium))
                )
            }
            item {
                RecommendationHorizontalList(
                    recommendationList =
                    fesUiState.recommendationLists[categoryUpdater.invoke(it)]!!,
                    onRecommendationCardPressed = onRecommendationCardPressed
                )
            }
        }
    }
}

@Composable
fun RecommendationHorizontalList(
    recommendationList: List<Recommendation>,
    onRecommendationCardPressed: (Recommendation) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row {
        LazyRow(horizontalArrangement = Arrangement.SpaceAround) {
            items(recommendationList) {
                RecommendationCard(
                    recommendation = it,
                    onCardClick = { onRecommendationCardPressed(it) },
                    modifier = modifier
                        .padding(dimensionResource(id = R.dimen.padding_small))
                )
            }
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
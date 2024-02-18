package com.nabilbdev.fes.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.nabilbdev.fes.data.model.Recommendation
import com.nabilbdev.fes.ui.viewmodel.FesUiState

@Composable
fun FeedScreen(
    fesUiState: FesUiState,
    onRecommendationCardPressed: (Recommendation) -> Unit,
    modifier: Modifier = Modifier
) {

    val recommendations = fesUiState.currentRecommendationList
    Column(modifier = modifier.padding(8.dp)) {
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn {
            items(recommendations) {
                RecommendationCard(
                    recommendation = it,
                    onCardClick = { onRecommendationCardPressed(it) }
                )
            }
        }
    }
}


@Composable
fun RecommendationCard(
    recommendation: Recommendation,
    onCardClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(8.dp),
        onClick = onCardClick
    ) {
        Image(
            painter = painterResource(id = recommendation.imageResourceId),
            contentDescription = null,
            modifier = modifier.fillMaxHeight()
        )
        Text(text = recommendation.name)
    }
}
package com.nabilbdev.fes.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.nabilbdev.fes.R
import com.nabilbdev.fes.model.Recommendation

@Composable
fun FeedScreen(
    fesUiState: FesUiState,
    onRecommendationCardPressed: (Recommendation) -> Unit,
    modifier: Modifier = Modifier
) {

    val recommendations = fesUiState.currentRecommendationList
    Column(modifier = modifier.padding(8.dp)) {
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.titleLarge
        )
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
package com.nabilbdev.fes.ui.screens

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nabilbdev.fes.data.model.Recommendation
import com.nabilbdev.fes.ui.screens.feed.FeedScreen
import com.nabilbdev.fes.ui.screens.feed.FesFeedTopAppBar
import com.nabilbdev.fes.ui.screens.recommendation.RecommendationScreen
import com.nabilbdev.fes.ui.theme.FesTheme
import com.nabilbdev.fes.ui.viewmodel.FesViewModel

@Composable
fun FesApp() {

    val viewModel: FesViewModel = viewModel()
    val fesUiState by viewModel.uiState.collectAsState()
    val currentRecommendation = fesUiState.currentSelectedRecommendation

    Scaffold(
        topBar = {
            FesFeedTopAppBar()
        }
    ) { innerPadding ->

        FeedScreen(
            fesUiState = fesUiState,
            categoryUpdater = { categoryOption ->
                viewModel.updateRecommendationListWithCategoryOption(categoryOption)
            },
            onRecommendationCardPressed = { recommendation: Recommendation ->
                viewModel.updateSelectedRecommendation(recommendation)
            },
            contentPadding = innerPadding
        )
    }

    if (!fesUiState.isShowingFeed) {
        RecommendationScreen(
            recommendation = currentRecommendation,
            onBackButtonClicked = {},
            stars = viewModel.updateReviewStars(recommendation = currentRecommendation),
        )
    }
}

@Preview(apiLevel = 33, showSystemUi = true, showBackground = true)
@Composable
fun FesAppPreview() {
    FesTheme {
        FesApp()
    }

}
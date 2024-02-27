package com.nabilbdev.fes.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nabilbdev.fes.data.model.Recommendation
import com.nabilbdev.fes.ui.screens.recommendation.RecommendationScreen
import com.nabilbdev.fes.ui.theme.FesTheme
import com.nabilbdev.fes.ui.viewmodel.FesViewModel

@Composable
fun FesApp(
    modifier: Modifier = Modifier
) {

    val viewModel: FesViewModel = viewModel()
    val fesUiState = viewModel.uiState.collectAsState().value
    val currentRecommendation = fesUiState.currentSelectedRecommendation

    if (fesUiState.isShowingFeed) {
        FeedScreen(
            fesUiState = fesUiState,
            categoryUpdater = {
                viewModel.updateRecommendationListWithCategoryOption(it)
            },
            onRecommendationCardPressed = { recommendation: Recommendation ->
                viewModel.updateSelectedRecommendation(recommendation)
            },
            modifier = modifier
        )
    } else {
        RecommendationScreen(
            recommendation = currentRecommendation,
            onBackButtonClicked = {

            },
            stars = viewModel.updateReviewStars(recommendation = currentRecommendation)
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
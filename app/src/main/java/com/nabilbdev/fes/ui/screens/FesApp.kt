package com.nabilbdev.fes.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nabilbdev.fes.data.model.Recommendation
import com.nabilbdev.fes.ui.viewmodel.FesViewModel

@Composable
fun FesApp(
    modifier: Modifier = Modifier
) {

    val viewModel: FesViewModel = viewModel()
    val fesUiState = viewModel.uiState.collectAsState().value

    if (fesUiState.isShowingFeed) {
        FeedScreen(
            fesUiState = fesUiState,
            onRecommendationCardPressed = { recommendation: Recommendation ->
                viewModel.updateSelectedRecommendation(recommendation)
            },
            modifier = modifier
        )
    } else {
        RecommendationScreen(
            recommendation = fesUiState.currentSelectedRecommendation,
            onBackButtonClicked = {}
        )
    }
    /**
     *
     * TODO( """ Update the review as the selected recommendation updates
    based on the category options."""
    )
     */
}

@Preview(showSystemUi = true)
@Composable
fun FesAppPreview() {
    FesApp()
}
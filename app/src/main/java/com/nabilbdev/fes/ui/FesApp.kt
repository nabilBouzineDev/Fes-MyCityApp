package com.nabilbdev.fes.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nabilbdev.fes.model.Recommendation

@Composable
fun FesApp(
    modifier: Modifier = Modifier
) {

    val viewModel: FesViewModel = viewModel()
    val fesUiState = viewModel.uiState.collectAsState().value

    FeedScreen(
        fesUiState = fesUiState,
        onRecommendationCardPressed = { recommendation: Recommendation ->
            viewModel.updateRecommendationDetailsScreenStates(recommendation)
        },
        modifier = modifier
    )
}

@Preview(showSystemUi = true)
@Composable
fun FesAppPreview() {
    FesApp()
}
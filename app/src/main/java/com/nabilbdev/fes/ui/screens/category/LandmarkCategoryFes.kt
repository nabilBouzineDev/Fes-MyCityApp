package com.nabilbdev.fes.ui.screens.category

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.nabilbdev.fes.data.model.Recommendation

@Composable
fun LandmarkCategoryScreen(
    landmarksList: List<Recommendation>,
    onRecommendationCardPressed: (Recommendation) -> Unit,
    contentPadding: PaddingValues
) {
    BaseCategoryScreen(
        recommendationList = landmarksList,
        onRecommendationCardPressed = onRecommendationCardPressed,
        contentPadding = contentPadding
    )
}
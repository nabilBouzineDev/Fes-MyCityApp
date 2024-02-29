package com.nabilbdev.fes.ui.screens.category

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.nabilbdev.fes.data.model.Recommendation

@Composable
fun HotelCategoryScreen(
    hotelsList: List<Recommendation>,
    onRecommendationCardPressed: (Recommendation) -> Unit,
    contentPadding: PaddingValues
) {
    BaseCategoryScreen(
        recommendationList = hotelsList,
        onRecommendationCardPressed = onRecommendationCardPressed,
        contentPadding = contentPadding
    )
}
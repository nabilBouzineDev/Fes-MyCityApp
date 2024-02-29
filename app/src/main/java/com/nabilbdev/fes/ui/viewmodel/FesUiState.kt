package com.nabilbdev.fes.ui.viewmodel

import com.nabilbdev.fes.data.DataSourceProvider
import com.nabilbdev.fes.data.model.CategoryOptions
import com.nabilbdev.fes.data.model.Recommendation

data class FesUiState(
    val recommendationLists: Map<CategoryOptions, List<Recommendation>> = emptyMap(),
    val currentSelectedCategory: CategoryOptions = CategoryOptions.LANDMARKS,
    val currentSelectedRecommendation: Recommendation = DataSourceProvider.defaultRecommendation,
    val isShowingFeed: Boolean = true,
    val selectedBottomNavItem: Int = 0
) {
    val currentRecommendationList: List<Recommendation> by lazy {
        recommendationLists[currentSelectedCategory]!!
    }
}
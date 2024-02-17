package com.nabilbdev.fes.ui

import com.nabilbdev.fes.data.DataSourceProvider
import com.nabilbdev.fes.model.CategoryOptions
import com.nabilbdev.fes.model.Recommendation

data class FesUiState(
    val recommendationLists: Map<CategoryOptions, List<Recommendation>> = emptyMap(),
    val currentSelectedCategory: CategoryOptions = CategoryOptions.LANDMARK,
    val currentSelectedRecommendation: Recommendation = DataSourceProvider.defaultRecommendation,
    val isShowingFeed: Boolean = true
) {
    val currentRecommendationList: List<Recommendation> by lazy {
        recommendationLists[currentSelectedCategory]!!
    }
}
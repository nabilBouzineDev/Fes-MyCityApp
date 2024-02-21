package com.nabilbdev.fes.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.nabilbdev.fes.data.DataSourceProvider
import com.nabilbdev.fes.data.model.CategoryOptions
import com.nabilbdev.fes.data.model.Recommendation
import com.nabilbdev.fes.ui.utils.FesPlacesReview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FesViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(FesUiState())
    val uiState = _uiState.asStateFlow()

    init {
        initializeUiState()
    }

    /** Here we just map each [CategoryOptions] with its corresponding recommendations */
    private fun initializeUiState() {
        val recommendationsCategoryBased =
            DataSourceProvider.allRecommendations.groupBy { it.categoryOptions }
        _uiState.value =
            FesUiState(
                recommendationLists = recommendationsCategoryBased,
                currentSelectedRecommendation =
                recommendationsCategoryBased[CategoryOptions.LANDMARK]?.get(0)
                    ?: DataSourceProvider.defaultRecommendation
            )
    }

    fun updateSelectedRecommendation(recommendation: Recommendation) {
        _uiState.update {
            it.copy(
                currentSelectedRecommendation = recommendation,
                isShowingFeed = false
            )
        }
    }

    fun updateReviewStars(recommendation: Recommendation): Int {
        return when (recommendation.review) {
            FesPlacesReview.FIVE -> 5
            FesPlacesReview.FOUR -> 4
            FesPlacesReview.THREE -> 3
            FesPlacesReview.TWO -> 2
            FesPlacesReview.ONE -> 1
            else -> 0
        }
    }

    fun updateSelectedCategoryOption(categoryOptions: CategoryOptions) {
        _uiState.update {
            it.copy(
                currentSelectedCategory = categoryOptions,
                isShowingFeed = false
            )
        }
    }
}
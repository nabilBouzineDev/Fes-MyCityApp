package com.nabilbdev.fes.ui

import androidx.lifecycle.ViewModel
import com.nabilbdev.fes.data.DataSourceProvider
import com.nabilbdev.fes.model.CategoryOptions
import com.nabilbdev.fes.model.Recommendation
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

    fun updateRecommendationDetailsScreenStates(recommendation: Recommendation) {
        _uiState.update {
            it.copy(
                currentSelectedRecommendation = recommendation,
                isShowingFeed = false
            )
        }
    }
}
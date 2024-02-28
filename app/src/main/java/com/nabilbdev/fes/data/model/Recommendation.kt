package com.nabilbdev.fes.data.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Stable
import com.nabilbdev.fes.ui.utils.FesPlacesReview

@Stable
data class Recommendation(
    val name: String,
    val description: String,
    val review: FesPlacesReview,
    val categoryOptions: CategoryOptions,
    val price: Int?,
    @DrawableRes val imageResourceId: Int
)
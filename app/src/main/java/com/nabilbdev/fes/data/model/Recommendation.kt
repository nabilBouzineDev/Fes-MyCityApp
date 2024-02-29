package com.nabilbdev.fes.data.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import com.nabilbdev.fes.ui.utils.FesPlacesReview
import java.util.UUID

@Immutable
data class Recommendation(
    val name: String,
    val description: String,
    val review: FesPlacesReview,
    val categoryOptions: CategoryOptions,
    @DrawableRes val imageResourceId: Int,
    val id: String = UUID.randomUUID().toString()
)
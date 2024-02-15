package com.nabilbdev.fes.model

import androidx.annotation.DrawableRes
import com.nabilbdev.fes.utils.FesPlacesReview

sealed class CategoryItem(
    open val name: String,
    open val description: String,
    open val review: FesPlacesReview,
    @DrawableRes open val imageResourceId: Int
) {

    data class Landmark(
        override val name: String,
        override val description: String,
        override val review: FesPlacesReview,
        override val imageResourceId: Int
    ) : CategoryItem(name, description, review, imageResourceId)

    data class Restaurant(
        override val name: String,
        override val description: String,
        override val review: FesPlacesReview,
        override val imageResourceId: Int
    ) : CategoryItem(name, description, review, imageResourceId)

    data class Hotel(
        override val name: String,
        override val description: String,
        override val review: FesPlacesReview,
        val price: Int,
        override val imageResourceId: Int
    ) : CategoryItem(name, description, review, imageResourceId)

}
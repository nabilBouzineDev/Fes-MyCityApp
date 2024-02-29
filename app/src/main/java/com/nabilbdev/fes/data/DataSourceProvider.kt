package com.nabilbdev.fes.data

import com.nabilbdev.fes.R
import com.nabilbdev.fes.data.model.CategoryOptions
import com.nabilbdev.fes.data.model.Recommendation
import com.nabilbdev.fes.ui.utils.FesPlacesReview

/** Map of available CategoryItem to be displayed in Category Fragments*/
object DataSourceProvider {

    val defaultRecommendation: Recommendation = Recommendation(
        name = "",
        description = "",
        review = FesPlacesReview.NONE,
        categoryOptions = CategoryOptions.LANDMARKS,
        imageResourceId = R.drawable.land1
    )

    val allRecommendations = listOf(
        Recommendation(
            name = "Al-Qarawiyyin University",
            description = "The University of al-Qarawiyyin is one of the oldest universities in the world. It was founded over a thousand years ago, in 859 AD, by a woman named Fatima al-Fihri. The university has a rich history and is known for its Islamic studies and Arabic language programs.",
            review = FesPlacesReview.FIVE,
            categoryOptions = CategoryOptions.LANDMARKS,
            imageResourceId = R.drawable.land1
        ),

        Recommendation(
            name = "Madrasa al-Attarine",
            description = "The Al-Attarine Madrasawas built over 600 years ago as a school for students to learn about Islam and other subjects. Today, the madrasa is not used as a school anymore but it is open to visitors who can explore its beautiful architecture.",
            review = FesPlacesReview.FOUR,
            categoryOptions = CategoryOptions.LANDMARKS,
            imageResourceId = R.drawable.land2
        ),

        Recommendation(
            name = "Bab Ftouh",
            description = "Bab Ftouh is the main southeastern gate of Fes el-Bali, the old walled city of Fes, Morocco.",
            review = FesPlacesReview.THREE,
            categoryOptions = CategoryOptions.LANDMARKS,
            imageResourceId = R.drawable.land3
        ),

        Recommendation(
            name = "Al-Qarawiyyin University",
            description = "The University of al-Qarawiyyin is one of the oldest universities in the world. It was founded over a thousand years ago, in 859 AD, by a woman named Fatima al-Fihri. The university has a rich history and is known for its Islamic studies and Arabic language programs.",
            review = FesPlacesReview.FIVE,
            categoryOptions = CategoryOptions.LANDMARKS,
            imageResourceId = R.drawable.land1
        ),

        Recommendation(
            name = "Madrasa al-Attarine",
            description = "The Al-Attarine Madrasawas built over 600 years ago as a school for students to learn about Islam and other subjects. Today, the madrasa is not used as a school anymore but it is open to visitors who can explore its beautiful architecture.",
            review = FesPlacesReview.FOUR,
            categoryOptions = CategoryOptions.LANDMARKS,
            imageResourceId = R.drawable.land2
        ),

        Recommendation(
            name = "Bab Ftouh",
            description = "Bab Ftouh is the main southeastern gate of Fes el-Bali, the old walled city of Fes, Morocco.",
            review = FesPlacesReview.THREE,
            categoryOptions = CategoryOptions.LANDMARKS,
            imageResourceId = R.drawable.land3
        ),

        Recommendation(
            name = "Cafe Clock",
            description = " Good luck finding this magnificently restored house in the old medina turned into a cafe. Look for the sign or ask a shopkeeper. The people are super friendly (and speak English) and the food is excellent. Service can be slow.",
            review = FesPlacesReview.FOUR,
            categoryOptions = CategoryOptions.RESTAURANTS,
            imageResourceId = R.drawable.restaurant1
        ),

        Recommendation(
            name = "La Kasbah Restaurant",
            description = "Friendly service, a solid selection of inexpensive Moroccan staples (excellent vegetarian tagine) and a couple of lovely high terraces overlooking the Gate on one side and the medina on the other.",
            review = FesPlacesReview.THREE,
            categoryOptions = CategoryOptions.RESTAURANTS,
            imageResourceId = R.drawable.restaurant2
        ),

        Recommendation(
            name = "Restaurant DAR SAADA",
            description = "Located in the centre of the medina, this restaurant is a favorite of Travel and Leisure magazine and is worth the indulgence.",
            review = FesPlacesReview.ONE,
            categoryOptions = CategoryOptions.RESTAURANTS,
            imageResourceId = R.drawable.restaurant3
        ),
        Recommendation(
            name = "Cafe Clock",
            description = " Good luck finding this magnificently restored house in the old medina turned into a cafe. Look for the sign or ask a shopkeeper. The people are super friendly (and speak English) and the food is excellent. Service can be slow.",
            review = FesPlacesReview.FOUR,
            categoryOptions = CategoryOptions.RESTAURANTS,
            imageResourceId = R.drawable.restaurant1
        ),

        Recommendation(
            name = "La Kasbah Restaurant",
            description = "Friendly service, a solid selection of inexpensive Moroccan staples (excellent vegetarian tagine) and a couple of lovely high terraces overlooking the Gate on one side and the medina on the other.",
            review = FesPlacesReview.THREE,
            categoryOptions = CategoryOptions.RESTAURANTS,
            imageResourceId = R.drawable.restaurant2
        ),

        Recommendation(
            name = "Restaurant DAR SAADA",
            description = "Located in the centre of the medina, this restaurant is a favorite of Travel and Leisure magazine and is worth the indulgence.",
            review = FesPlacesReview.ONE,
            categoryOptions = CategoryOptions.RESTAURANTS,
            imageResourceId = R.drawable.restaurant3
        ),

        Recommendation(
            name = "RIAD VERUS",
            description = "Derb Arset Bennis, Batha - safe choice. Excellent wifi. Favourite for students looking for a homestay. Cheap deals to be had. Lush views.",
            review = FesPlacesReview.THREE,
            categoryOptions = CategoryOptions.HOTELS,
            imageResourceId = R.drawable.hotel1
        ),

        Recommendation(
            name = "Dar Bouanania",
            description = "Riad-style, wonderfully decorated rooms, nice roof-terrace, wifi and very welcoming staff. double Dh 250-400.",
            review = FesPlacesReview.TWO,
            categoryOptions = CategoryOptions.HOTELS,
            imageResourceId = R.drawable.hotel2
        ),

        Recommendation(
            name = "Riad Jamai",
            description = "A traditional riad that has been restored to its former slendour, with extremely helpful and welcoming staff. The rooms are large and comfortable and the breakfast will keep you going all day.",
            review = FesPlacesReview.FOUR,
            categoryOptions = CategoryOptions.HOTELS,
            imageResourceId = R.drawable.hotel3
        ),
        Recommendation(
            name = "RIAD VERUS",
            description = "Derb Arset Bennis, Batha - safe choice. Excellent wifi. Favourite for students looking for a homestay. Cheap deals to be had. Lush views.",
            review = FesPlacesReview.THREE,
            categoryOptions = CategoryOptions.HOTELS,
            imageResourceId = R.drawable.hotel1
        ),

        Recommendation(
            name = "Dar Bouanania",
            description = "Riad-style, wonderfully decorated rooms, nice roof-terrace, wifi and very welcoming staff. double Dh 250-400.",
            review = FesPlacesReview.TWO,
            categoryOptions = CategoryOptions.HOTELS,
            imageResourceId = R.drawable.hotel2
        ),

        Recommendation(
            name = "Riad Jamai",
            description = "A traditional riad that has been restored to its former slendour, with extremely helpful and welcoming staff. The rooms are large and comfortable and the breakfast will keep you going all day.",
            review = FesPlacesReview.FOUR,
            categoryOptions = CategoryOptions.HOTELS,
            imageResourceId = R.drawable.hotel3
        )
    )
}
package com.nabilbdev.fes.data

import com.nabilbdev.fes.R
import com.nabilbdev.fes.model.CategoryItem.Hotel
import com.nabilbdev.fes.model.CategoryItem.Landmark
import com.nabilbdev.fes.model.CategoryItem.Restaurant
import com.nabilbdev.fes.utils.FesPlacesReview

/** Map of available CategoryItem to be displayed in Category Fragments*/
object DataSourceProvider {

    val landmarks = listOf(
        Landmark(
            name = "Al-Qarawiyyin Mosque-University",
            description = "The University of al-Qarawiyyin is one of the oldest universities in the world. It was founded over a thousand years ago, in 859 AD, by a woman named Fatima al-Fihri. The university has a rich history and is known for its Islamic studies and Arabic language programs.",
            review = FesPlacesReview.FIVE,
            imageResourceId = R.drawable.land1
        ),
        Landmark(
            name = "Madrasa al-Attarine",
            description = "The Al-Attarine Madrasawas built over 600 years ago as a school for students to learn about Islam and other subjects. Today, the madrasa is not used as a school anymore but it is open to visitors who can explore its beautiful architecture.",
            review = FesPlacesReview.FOUR,
            imageResourceId = R.drawable.land2
        ),
        Landmark(
            name = "Bab Ftouh",
            description = "Bab Ftouh is the main southeastern gate of Fes el-Bali, the old walled city of Fes, Morocco.",
            review = FesPlacesReview.THREE,
            imageResourceId = R.drawable.land3
        )
    )

    val restaurants = listOf(
        Restaurant(
            name = "Cafe Clock",
            description = " Good luck finding this magnificently restored house in the old medina turned into a cafe. Look for the sign or ask a shopkeeper. The people are super friendly (and speak English) and the food is excellent. Service can be slow.",
            review = FesPlacesReview.FOUR,
            imageResourceId = R.drawable.restaurant1
        ),
        Restaurant(
            name = "La Kasbah Restaurant",
            description = "Friendly service, a solid selection of inexpensive Moroccan staples (excellent vegetarian tagine) and a couple of lovely high terraces overlooking the Gate on one side and the medina on the other.",
            review = FesPlacesReview.THREE,
            imageResourceId = R.drawable.restaurant2
        ),
        Restaurant(
            name = "Restaurant DAR SAADA",
            description = "Located in the centre of the medina, this restaurant is a favorite of Travel and Leisure magazine and is worth the indulgence.",
            review = FesPlacesReview.FOUR,
            imageResourceId = R.drawable.restaurant3
        )
    )

    val hotels = listOf(
        Hotel(
            name = "RIAD VERUS",
            description = "Derb Arset Bennis, Batha - safe choice. Excellent wifi. Favourite for students looking for a homestay. Cheap deals to be had. Lush views.",
            review = FesPlacesReview.THREE,
            price = 274,
            imageResourceId = R.drawable.hotel1
        ),
        Hotel(
            name = "Dar Bouanania",
            description = "Riad-style, wonderfully decorated rooms, nice roof-terrace, wifi and very welcoming staff. double Dh 250-400.",
            review = FesPlacesReview.THREE,
            price = 250,
            imageResourceId = R.drawable.hotel2
        ),
        Hotel(
            name = "Riad Jamai",
            description = "A traditional riad that has been restored to its former slendour, with extremely helpful and welcoming staff. The rooms are large and comfortable and the breakfast will keep you going all day.",
            review = FesPlacesReview.FOUR,
            price = 507,
            imageResourceId = R.drawable.hotel3
        )
    )
}
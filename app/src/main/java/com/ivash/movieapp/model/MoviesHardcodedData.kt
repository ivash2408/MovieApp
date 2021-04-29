package com.ivash.movieapp.model

import com.ivash.movieapp.R

object MoviesHardcodedData {
    fun getMoviesData(): List<MovieData> = arrayListOf(
        MovieData(
            imageResId = R.drawable.movie_card_img,
            ageLimit = 13,
            isLiked = false,
            genre = "Action, Adventure, Drama",
            rating = 4,
            reviewsCount = 125,
            title = "Avengers: End game",
            movieLength = 137
        ),
        MovieData(
            imageResId = R.drawable.tenet,
            ageLimit = 16,
            isLiked = true,
            genre = "Action, Sci-Fi, Thriller",
            rating = 5,
            reviewsCount = 98,
            title = "Tenet",
            movieLength = 97
        ),
        MovieData(
            imageResId = R.drawable.black_widow,
            ageLimit = 13,
            isLiked = false,
            genre = "Action, Adventure, Sci-Fi",
            rating = 4,
            reviewsCount = 38,
            title = "Black Widow",
            movieLength = 102
        ),
        MovieData(
            imageResId = R.drawable.ww84,
            ageLimit = 13,
            isLiked = false,
            genre = "Action, Adventure, Fantasy",
            rating = 5,
            reviewsCount = 74,
            title = "Wonder Woman 1984",
            movieLength = 120
        )
    )
}
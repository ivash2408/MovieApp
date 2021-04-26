package com.ivash.movieapp.model

import com.ivash.movieapp.R

object MoviesHardcodedData {
    fun getMoviesData(): List<MovieData> = arrayListOf(
        MovieData(
            R.drawable.movie_card_img,
            13,
            false,
            "Action, Adventure, Drama",
            4,
            125,
            "Avengers: End game",
            137
        ),
        MovieData(
            R.drawable.tenet,
            16,
            true,
            "Action, Sci-Fi, Thriller",
            5,
            98,
            "Tenet",
            97
        ),
        MovieData(
            R.drawable.black_widow,
            13,
            false,
            "Action, Adventure, Sci-Fi",
            4,
            38,
            "Black Widow",
            102
        ),
        MovieData(
            R.drawable.ww84,
            13,
            false,
            "Action, Adventure, Fantasy",
            5,
            74,
            "Wonder Woman 1984",
            120
        )
    )
}
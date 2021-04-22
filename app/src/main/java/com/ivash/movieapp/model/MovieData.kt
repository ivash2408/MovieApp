package com.ivash.movieapp.model

data class MovieData(
     val image: Int,
     val ageLimit: Int,
     val isLiked: Boolean,
     val genre: String,
     val rating: Int,
     val reviewsCount: Int,
     val title: String,
     val movieLength: Int
)

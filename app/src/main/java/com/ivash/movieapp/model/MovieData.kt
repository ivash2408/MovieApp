package com.ivash.movieapp.model

import androidx.annotation.DrawableRes

data class MovieData(
     @DrawableRes
     val imageResId: Int,
     val ageLimit: Int,
     val isLiked: Boolean,
     val genre: String,
     val rating: Int,
     val reviewsCount: Int,
     val title: String,
     val movieLength: Int
)

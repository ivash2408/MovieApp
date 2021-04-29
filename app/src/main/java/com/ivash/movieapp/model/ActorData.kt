package com.ivash.movieapp.model

import androidx.annotation.DrawableRes

data class ActorData(
    val name: String,
    @DrawableRes
    val actorPhotoResId: Int,
)

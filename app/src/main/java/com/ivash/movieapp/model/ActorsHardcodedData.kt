package com.ivash.movieapp.model

import com.ivash.movieapp.R

object ActorsHardcodedData {
    fun getActorsData(): List<ActorData> = arrayListOf(
        ActorData(
            name = "Robert Downey Jr",
            actorPhotoResId = R.drawable.robert_downey
        ),
        ActorData(
            name = "Chris Evans",
            actorPhotoResId = R.drawable.evans
        ),
        ActorData(
            name = "Mark Ruffalo",
            actorPhotoResId = R.drawable.ruffalo
        ),
        ActorData(
            name = "Chris Hemsworth",
            actorPhotoResId = R.drawable.hemsworth
        )
    )
}
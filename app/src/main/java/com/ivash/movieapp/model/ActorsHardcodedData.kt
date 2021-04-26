package com.ivash.movieapp.model

import com.ivash.movieapp.R

object ActorsHardcodedData {
    fun getActorsData(): List<ActorData> = arrayListOf(
        ActorData(
            "Robert Downey Jr",
            R.drawable.robert_downey
        ),
        ActorData(
            "Chris Evans",
            R.drawable.evans
        ),
        ActorData(
            "Mark Ruffalo",
            R.drawable.ruffalo
        ),
        ActorData(
            "Chris Hemsworth",
            R.drawable.hemsworth
        )
    )
}
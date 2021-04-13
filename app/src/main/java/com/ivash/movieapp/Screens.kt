package com.ivash.movieapp

import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun MovieListFragment(): FragmentScreen = FragmentScreen { FragmentMoviesList() }
    fun MovieDesctiptionFragment(): FragmentScreen = FragmentScreen{ FragmentMovieDetails() }
}
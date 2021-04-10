package com.ivash.movieapp

import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun MovieListFragment() = FragmentScreen {FragmentMoviesList()}
    fun MovieDesctiptionFragment() = FragmentScreen{FragmentMovieDetails()}
}
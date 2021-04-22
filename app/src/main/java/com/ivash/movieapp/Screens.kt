package com.ivash.movieapp

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.ivash.movieapp.movieDetails.FragmentMovieDetails
import com.ivash.movieapp.movieList.FragmentMoviesList

object Screens {
    fun MovieListFragment(): FragmentScreen = FragmentScreen { FragmentMoviesList() }
    fun MovieDesctiptionFragment(): FragmentScreen = FragmentScreen{ FragmentMovieDetails() }
}
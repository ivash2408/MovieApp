package com.ivash.movieapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.github.terrakok.cicerone.Cicerone
import com.ivash.movieapp.databinding.FragmentMoviesListBinding

class FragmentMoviesList : Fragment(R.layout.fragment_movies_list) {
    private var _binding: FragmentMoviesListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesListBinding.inflate(inflater, container, false)

        binding.movieCard.setOnClickListener {openMovieDescription()}
        return binding.root
    }

    fun openMovieDescription() {
        router?.navigateTo(Screens.MovieDesctiptionFragment())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
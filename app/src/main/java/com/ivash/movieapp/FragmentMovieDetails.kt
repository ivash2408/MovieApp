package com.ivash.movieapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ivash.movieapp.databinding.FragmentMovieDetailsBinding
import com.ivash.movieapp.databinding.FragmentMoviesListBinding

class FragmentMovieDetails : Fragment(R.layout.fragment_movie_details) {
    private val binding by viewBinding(FragmentMovieDetailsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvBack.setOnClickListener { backToMovieList() }
    }

    private fun backToMovieList() {
        router?.exit()
    }
}
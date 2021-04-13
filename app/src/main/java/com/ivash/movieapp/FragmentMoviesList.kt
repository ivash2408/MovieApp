package com.ivash.movieapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ivash.movieapp.databinding.FragmentMoviesListBinding

class FragmentMoviesList : Fragment(R.layout.fragment_movies_list) {
    private val binding by viewBinding(FragmentMoviesListBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.movieCard.movieCardView.setOnClickListener { openMovieDescription() }
    }

    private fun openMovieDescription() {
        router?.navigateTo(Screens.MovieDesctiptionFragment())
    }
}
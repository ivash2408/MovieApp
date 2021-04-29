package com.ivash.movieapp.movieList

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ivash.movieapp.R
import com.ivash.movieapp.Screens
import com.ivash.movieapp.databinding.FragmentMoviesListBinding
import com.ivash.movieapp.model.MovieData
import com.ivash.movieapp.model.MoviesHardcodedData
import com.ivash.movieapp.router

class FragmentMoviesList : Fragment(R.layout.fragment_movies_list) {
    private val binding by viewBinding(FragmentMoviesListBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var spanCount = 2;
        context?.resources?.displayMetrics?.run {
            spanCount = widthPixels / densityDpi
        }
        binding.recycler.layoutManager = GridLayoutManager(this.context, spanCount)
        val customAdapter = MovieListAdapter { movieData ->
            openMovieDescription(movieData)
        }
        binding.recycler.adapter = customAdapter
        customAdapter.submitList(MoviesHardcodedData.getMoviesData())
    }

    private fun openMovieDescription(movieData: MovieData) {
        router?.navigateTo(Screens.MovieDesctiptionFragment())
    }

    companion object {
        fun newInstance(): FragmentMoviesList = FragmentMoviesList()
    }
}
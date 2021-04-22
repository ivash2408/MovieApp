package com.ivash.movieapp.movieList

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ivash.movieapp.R
import com.ivash.movieapp.Screens
import com.ivash.movieapp.databinding.FragmentMoviesListBinding
import com.ivash.movieapp.model.MoviesData
import com.ivash.movieapp.router

class FragmentMoviesList : Fragment(R.layout.fragment_movies_list) {
    private val binding by viewBinding(FragmentMoviesListBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.apply {
            this.layoutManager = GridLayoutManager(this.context, 2)
            val adapter = MovieListAdapter()
            this.adapter = adapter
            adapter.submitList(MoviesData.getMoviesData())
        }
    }

    private fun openMovieDescription() {
        router?.navigateTo(Screens.MovieDesctiptionFragment())
    }
}
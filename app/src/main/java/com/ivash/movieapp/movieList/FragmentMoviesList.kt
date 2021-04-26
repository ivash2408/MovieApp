package com.ivash.movieapp.movieList

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ivash.movieapp.R
import com.ivash.movieapp.Screens
import com.ivash.movieapp.databinding.FragmentMoviesListBinding
import com.ivash.movieapp.model.MoviesHardcodedData
import com.ivash.movieapp.router

class FragmentMoviesList : Fragment(R.layout.fragment_movies_list) {
    private val binding by viewBinding(FragmentMoviesListBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.layoutManager = GridLayoutManager(this.context, 2)
        val customAdapter = MovieListAdapter()
        customAdapter.setOnItemClickListener(object : MovieListAdapter.ItemOnClickListener {
            override fun itemOnClick(position: Int) {
                openMovieDescription()
            }
        })
        binding.recycler.adapter = customAdapter
        customAdapter.submitList(MoviesHardcodedData.getMoviesData())
    }

    private fun openMovieDescription() {
        router?.navigateTo(Screens.MovieDesctiptionFragment())
        println("It used")
    }


    companion object {
        fun newInstance(): FragmentMoviesList = FragmentMoviesList()
    }
}
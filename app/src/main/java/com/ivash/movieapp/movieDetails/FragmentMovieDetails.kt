package com.ivash.movieapp.movieDetails

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ivash.movieapp.R
import com.ivash.movieapp.databinding.FragmentMovieDetailsBinding
import com.ivash.movieapp.model.ActorsHardcodedData
import com.ivash.movieapp.router

class FragmentMovieDetails : Fragment(R.layout.fragment_movie_details) {
    private val binding by viewBinding(FragmentMovieDetailsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvBack.setOnClickListener { backToMovieList() }
        binding.actorsContainer.layoutManager =
            LinearLayoutManager(this.context, RecyclerView.HORIZONTAL, false)
        val customAdapter = ActorsAdapter()
        binding.actorsContainer.adapter = customAdapter
        customAdapter.submitList(ActorsHardcodedData.getActorsData())
    }

    private fun backToMovieList() {
        router?.exit()
    }

    companion object {
        fun newInstance(): FragmentMovieDetails = FragmentMovieDetails()
    }
}
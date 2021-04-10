package com.ivash.movieapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ivash.movieapp.databinding.FragmentMovieDetailsBinding
import com.ivash.movieapp.databinding.FragmentMoviesListBinding

class FragmentMovieDetails : Fragment(R.layout.fragment_movie_details) {
    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)

        binding.tvBack.setOnClickListener {backToMovieList()}
        return binding.root
    }

    fun backToMovieList() {
        router?.exit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
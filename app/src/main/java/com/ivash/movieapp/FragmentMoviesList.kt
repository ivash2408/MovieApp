package com.ivash.movieapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.ivash.movieapp.databinding.FragmentMoviesListBinding
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.pure.AppNavigator
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class FragmentMoviesList : Fragment(R.layout.fragment_movies_list) {
    private var _binding: FragmentMoviesListBinding? = null
    private val binding get() = _binding!!

    private val cicerone = Cicerone.create()
    private val navHolder = cicerone.navigatorHolder
    private val router = cicerone.router


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

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
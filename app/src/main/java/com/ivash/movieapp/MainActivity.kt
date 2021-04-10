package com.ivash.movieapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.ivash.movieapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val navigator: Navigator = AppNavigator(this, R.id.main_container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState == null) {
            router.replaceScreen(Screens.MovieListFragment())
        }

    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        (application as MovieApp).navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        (application as MovieApp).navigatorHolder.removeNavigator()
        super.onPause()
    }



}
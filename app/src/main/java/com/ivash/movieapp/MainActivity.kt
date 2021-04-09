package com.ivash.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ivash.movieapp.databinding.ActivityMainBinding
import ru.terrakok.cicerone.Cicerone

class MainActivity : AppCompatActivity() {
    private val cicerone = Cicerone.create()
    val router get() = cicerone.router
    val navigatorHolder get() = cicerone.getNavigatorHolder()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, FragmentMoviesList())
                .commit()
    }
}
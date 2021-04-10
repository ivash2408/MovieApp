package com.ivash.movieapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ivash.movieapp.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.pure.AppNavigator
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val cicerone = Cicerone.create()
    private val navHolder = cicerone.navigatorHolder
    private val router = cicerone.router

    private val navigator: Navigator = SupportAppNavigator(this, R.id.main_container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        INSTANCE = this
    }

    override fun onResume() {
        super.onResume()
        navHolder.setNavigator(navigator)
        val screen = MovieDetailsScreen
        router.navigateTo(screen)
    }

    override fun onPause() {
        navHolder.removeNavigator()
        super.onPause()
    }

    companion object {
        internal lateinit var INSTANCE: MainActivity
            private set

        fun getIntent(context: Context?) = Intent(context, MainActivity::class.java)
    }
}
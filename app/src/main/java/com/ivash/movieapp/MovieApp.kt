package com.ivash.movieapp

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router

class MovieApp : Application() {
    private val cicerone = Cicerone.create()
    val router: Router get() = cicerone.router
    val navigatorHolder: NavigatorHolder get() = cicerone.getNavigatorHolder()
}

val Activity.router: Router get() = (application as MovieApp).router
val Activity.navigatorHolder: NavigatorHolder get() = (application as MovieApp).navigatorHolder

val Fragment.router: Router? get() = activity?.router

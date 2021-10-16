package com.example.test.navigation

import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Screen

interface Navigation {

    fun navigationRouter(): Router

    fun navigationHolder(): NavigatorHolder

}
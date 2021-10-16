package com.example.test.navigation

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import javax.inject.Inject

class NavigationImpl @Inject constructor(): Navigation {

    private val navigation: Cicerone<Router> = Cicerone.create()

    override fun navigationRouter(): Router = navigation.router

    override fun navigationHolder(): NavigatorHolder = navigation.getNavigatorHolder()


}
package com.example.test.dependencies

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NavigationModule {

    private val navigation: Cicerone<Router> = Cicerone.create()

    @Provides
    @Singleton
    fun provideNavigationRouter(): Router = navigation.router

    @Provides
    @Singleton
    fun provideNavigationHolder(): NavigatorHolder = navigation.getNavigatorHolder()
}
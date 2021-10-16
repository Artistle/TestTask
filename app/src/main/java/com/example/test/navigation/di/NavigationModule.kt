package com.example.test.navigation.di

import com.example.test.navigation.Navigation
import com.example.test.navigation.NavigationImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface NavigationModule {

    @Binds
    @Singleton
    fun bindNavigation(impl: NavigationImpl): Navigation

}
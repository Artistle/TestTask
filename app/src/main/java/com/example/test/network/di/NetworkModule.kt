package com.example.test.network.di

import com.example.test.network.ServiceFactory
import com.example.test.network.ServiceFactoryImpl
import dagger.Binds
import dagger.Module

@Module
interface NetworkModule {

    @Binds
    fun bindNetwork(impl: ServiceFactoryImpl): ServiceFactory

}
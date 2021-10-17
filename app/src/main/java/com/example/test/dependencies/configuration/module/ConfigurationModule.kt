package com.example.test.dependencies.configuration.module

import com.example.test.dependencies.configuration.Configuration
import com.example.test.dependencies.configuration.ConfigurationImpl
import dagger.Binds
import dagger.Module

@Module
interface ConfigurationModule {

    @Binds
    fun bindConfiguration(impl: ConfigurationImpl): Configuration
}
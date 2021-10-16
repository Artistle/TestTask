package com.example.test.repositories.di

import com.example.test.repositories.Repository
import com.example.test.repositories.RepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindRepository(impl: RepositoryImpl): Repository

}
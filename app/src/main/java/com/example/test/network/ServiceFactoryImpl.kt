package com.example.test.network

import com.example.test.dependencies.configuration.Configuration
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ServiceFactoryImpl @Inject constructor(private val configuration: Configuration) : ServiceFactory {

    override fun <S> createService(apiClass: Class<S>): S {
        return retrofit2.Retrofit.Builder()
            .baseUrl(configuration.baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(apiClass)
    }
}
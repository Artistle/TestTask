package com.example.test.network

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ServiceFactoryImpl @Inject constructor() : ServiceFactory {

    private val BASE_URL = "https://api.stackexchange.com"

    override fun <S> createService(apiClass: Class<S>): S {
        return retrofit2.Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(apiClass)
    }
}
package com.example.test.network

interface ServiceFactory {

    fun <S>createService(apiClass: Class<S>): S

}
package com.example.test

import android.app.Application
import com.example.test.dependencies.AppComponent
import com.example.test.dependencies.DaggerAppComponent

class App : Application() {

    companion object {

        lateinit var appComponent: AppComponent

    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .build()
    }

}
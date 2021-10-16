package com.example.test

import android.app.Application
import com.example.test.dependencies.AppComponent
import com.example.test.dependencies.DaggerAppComponent


/**
*
*
 * Не лучшее решение, из проблем в проекте я могу выделить:
 *      плохой нэйминг, особенно с фрагментами.
 *      не успел придумать что делать с модулем для вью-модели, он должен быть 1 экземпляре
 *      по хорошему надо бы ещё проработать архитектуру, избавить от composible во вью моделях, и делатьб запросы только в слое репозитория
 *      но сделал как смог за такой короткий срок.
 *      в общей сумме потратил ~10-12 часов
*
* */


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
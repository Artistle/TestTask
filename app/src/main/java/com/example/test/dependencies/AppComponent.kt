package com.example.test.dependencies

import com.example.test.MainActivity
import com.example.test.fragments.enterRequest.ui.fragments.EnterRequestFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NavigationModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(fragment: EnterRequestFragment)

}
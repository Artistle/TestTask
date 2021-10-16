package com.example.test.dependencies

import com.example.test.MainActivity
import com.example.test.fragments.answerFragment.ui.fragments.AnswerFragment
import com.example.test.fragments.enterRequest.di.EnterRequestViewModelFactoriesModule
import com.example.test.fragments.enterRequest.ui.fragments.EnterRequestFragment
import com.example.test.navigation.di.NavigationModule
import com.example.test.network.di.NetworkModule
import com.example.test.repositories.di.RepositoryModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [NavigationModule::class,
        RepositoryModule::class,
        NetworkModule::class,
        EnterRequestViewModelFactoriesModule::class]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(fragment: EnterRequestFragment)
    fun inject(fragment: AnswerFragment)

}
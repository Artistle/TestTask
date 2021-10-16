package com.example.test.fragments.enterRequest.di

import androidx.lifecycle.ViewModel
import com.example.test.dependencies.viewmodel.AssistedSavedStateViewModelFactory
import com.example.test.dependencies.viewmodel.ViewModelKey
import com.example.test.fragments.answerFragment.viewmodel.AnswerViewModel
import com.example.test.fragments.enterRequest.viewmodel.EnterRequestViewModel
import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@AssistedModule
@Module(
    includes = [AssistedInject_EnterRequestViewModelFactoriesModule::class]
)
interface EnterRequestViewModelFactoriesModule {

    @Binds
    @IntoMap
    @ViewModelKey(EnterRequestViewModel::class)
    fun bindEnterRequestViewModelFactory(impl: EnterRequestViewModel.Factory): AssistedSavedStateViewModelFactory<out ViewModel>

    @Binds
    @IntoMap
    @ViewModelKey(AnswerViewModel::class)
    fun bindAnswerViewModelFactory(impl: AnswerViewModel.Factory): AssistedSavedStateViewModelFactory<out ViewModel>
}
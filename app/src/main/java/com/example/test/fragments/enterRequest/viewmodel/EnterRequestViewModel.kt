package com.example.test.fragments.enterRequest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.test.dependencies.viewmodel.AssistedSavedStateViewModelFactory
import com.example.test.fragments.answerFragment.viewmodel.AnswerViewModel
import com.example.test.models.Question
import com.example.test.repositories.Repository
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class EnterRequestViewModel @AssistedInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val repository: Repository
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val _responseLiveData = MutableLiveData<Question>()
    val responseLiveData = _responseLiveData

    private val _throwableLiveData = MutableLiveData<String>()
    val throwableLiveData = _throwableLiveData

    fun load(request: String) {
        compositeDisposable.add(repository.getListRequest(request)
            .doOnError { throwable ->
                _throwableLiveData.value = throwable.localizedMessage
            }
            .subscribe { result ->
                _responseLiveData.value = result
            })
    }

    @AssistedInject.Factory
    interface Factory : AssistedSavedStateViewModelFactory<EnterRequestViewModel> {

        override fun create(savedStateHandle: SavedStateHandle): EnterRequestViewModel
    }
}
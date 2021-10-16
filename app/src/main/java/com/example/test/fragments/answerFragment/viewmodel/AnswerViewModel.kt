package com.example.test.fragments.answerFragment.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.test.dependencies.viewmodel.AssistedSavedStateViewModelFactory
import com.example.test.models.Answer
import com.example.test.models.QuestionModel
import com.example.test.repositories.Repository
import com.squareup.inject.assisted.Assisted
import io.reactivex.disposables.CompositeDisposable
import com.squareup.inject.assisted.AssistedInject

class AnswerViewModel @AssistedInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val repository: Repository
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val _answerLiveData = MutableLiveData<Answer>()
    val answerLiveData = _answerLiveData

    private val _throwableLiveData = MutableLiveData<String>()
    val throwableLiveData = _throwableLiveData

    private val _items = MutableLiveData<QuestionModel>()
    val items = _items

    private val item: QuestionModel = savedStateHandle["ITEMS"] ?: error("can't get item")

    @SuppressLint("CheckResult")
    private fun load(ids: Int) {
        compositeDisposable.add(repository
            .getListAnswer(ids)
            .doOnError { throwable ->
                _throwableLiveData.value = throwable.localizedMessage
            }
            .subscribe { result ->
                _answerLiveData.value = result
            })

    }

    fun setItem(item: QuestionModel) {
        _items.value = item
        _items.value?.question_id?.let { load(it) }
    }

    fun setUpItems() {
        _items.value = item
    }

    @AssistedInject.Factory
    interface Factory : AssistedSavedStateViewModelFactory<AnswerViewModel> {

        override fun create(savedStateHandle: SavedStateHandle): AnswerViewModel
    }
}
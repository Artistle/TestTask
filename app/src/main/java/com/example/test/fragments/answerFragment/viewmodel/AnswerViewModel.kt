package com.example.test.fragments.answerFragment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test.models.Answer
import com.example.test.models.QuestionModel
import com.example.test.network.NetworkModule
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AnswerViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val _answerLiveData = MutableLiveData<Answer>()
    val answerLiveData = _answerLiveData

    private val _throwableLiveData = MutableLiveData<String>()
    val throwableLiveData = _throwableLiveData

    private val _items = MutableLiveData<QuestionModel>()
    val items = _items

    /*
    *
    * не успел сделать инжект во вью модель
    *
    * */
    private val networkModule = NetworkModule()

    private fun load(ids: Int) {
        compositeDisposable.add(networkModule.getApi().getListAnswer(ids)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnError {
                _throwableLiveData.value = it.localizedMessage
            }
            .subscribe { result ->
                _answerLiveData.value = result
            })
    }

    /*
    *
    * передача объекта во вью модель, на случай пересоздания фрагмента
    *
    * */
    fun setItem(item : QuestionModel) {
        _items.value = item
        _items.value?.question_id?.let { load(it) }
    }
}
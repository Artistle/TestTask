package com.example.test.fragments.enterRequest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test.models.Question
import com.example.test.network.NetworkModule
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class EnterRequestViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val _responseLiveData = MutableLiveData<Question>()
    val responseLiveData = _responseLiveData

    private val _throwableLiveData = MutableLiveData<String>()
    val throwableLiveData = _throwableLiveData

    /*
    *
    * не успел сделать инжект во вью модель
    *
    * */
    private val networkModule = NetworkModule()

    fun load(request: String) {
        compositeDisposable.add(networkModule.getApi().getListRequest(request)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnError {
                _throwableLiveData.value = it.localizedMessage
            }
            .subscribe { result ->
                _responseLiveData.value = result
            })
    }
}
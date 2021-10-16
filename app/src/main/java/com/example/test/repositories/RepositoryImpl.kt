package com.example.test.repositories

import com.example.test.models.Answer
import com.example.test.models.Question
import com.example.test.network.ServiceFactory
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val serviceFactory: ServiceFactory) : Repository {

    private val service = serviceFactory.createService(Repository::class.java)

    override fun getListRequest(query: String): Single<Question> {
        return service.getListRequest(query)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    override fun getListAnswer(ids: Int): Single<Answer> {
        return service.getListAnswer(ids)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}
package com.example.test.repositories

import com.example.test.models.Answer
import com.example.test.models.Question
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Repository {

    @GET("/search?order=desc&sort=activity&site=stackoverflow")
    fun getListRequest(@Query("tagged") query: String): Single<Question>

    @GET("/questions/{ids}/answers?order=desc&sort=activity&site=stackoverflow")
    fun getListAnswer(@Path("ids") ids: Int): Single<Answer>

}
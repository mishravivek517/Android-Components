package com.vivek.androidmvvm.networking

import com.vivek.androidmvvm.model.Question
import com.vivek.androidmvvm.model.QuestionList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {


//    @GET("posts/1")
//    suspend fun getPost(): Question
//
//    @GET("posts")
//    suspend fun getPosts(): List<Question>

    @GET("/2.2/questions?order=desc&sort=creation&site=stackoverflow")    //End Url
    fun fetchQuestions(@Query("tagged") tags: String): Call<QuestionList>

}
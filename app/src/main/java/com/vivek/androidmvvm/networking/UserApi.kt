package com.vivek.androidmvvm.networking

import com.vivek.androidmvvm.model.RecyclerData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {
    @GET("users")
    fun getDataFromApi(@Query("page") query: String ) : Call<RecyclerData>

}
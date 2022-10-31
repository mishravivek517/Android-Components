package com.vivek.androidmvvm.viewmodel

import com.vivek.androidmvvm.application.NetworkState
import com.vivek.androidmvvm.model.Movie
import com.vivek.androidmvvm.networking.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    suspend fun getAllMovies() : NetworkState<List<Movie>> {
            val response = retrofitService.getAllMovies()
            return if (response.isSuccessful) {
                val responseBody = response.body()
                if (responseBody != null) {
                    NetworkState.Success(responseBody)
                } else {
                    NetworkState.Error(response)
                }
            } else {
                NetworkState.Error(response)
            }
        }

}
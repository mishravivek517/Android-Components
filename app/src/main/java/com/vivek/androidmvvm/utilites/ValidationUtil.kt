package com.vivek.androidmvvm.utilites

import com.vivek.androidmvvm.model.Movie

object ValidationUtil {

    fun validateMovie(movie: Movie) : Boolean {
        if (movie.first_name.isNotEmpty() && movie.last_name.isNotEmpty()) {
            return true
        }
        return false
    }
}
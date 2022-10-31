package com.vivek.androidmvvm.utilites

import com.vivek.androidmvvm.model.Movie

object ValidationUtil {

    fun validateMovie(movie: Movie) : Boolean {
        if (movie.name.isNotEmpty() && movie.category.isNotEmpty()) {
            return true
        }
        return false
    }
}
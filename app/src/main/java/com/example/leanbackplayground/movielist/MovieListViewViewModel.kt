package com.example.leanbackplayground.movielist

import androidx.lifecycle.ViewModel
import com.example.leanbackplayground.Movie

class MovieListViewViewModel : ViewModel() {
    fun createList(): List<Movie> {
        val list = mutableListOf<Movie>()

        for (i in 0..10) {
            list.add(Movie(title = "Test$i"))
        }

        return list
    }
}
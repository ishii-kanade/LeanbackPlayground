package com.example.leanbackplayground

import androidx.lifecycle.ViewModel

data class MovieContent(
    val name: String
)

class GridViewViewModel : ViewModel() {
    fun createList(): List<MovieContent> {
        val list = mutableListOf<MovieContent>()
        list.add(MovieContent(name = "Test"))
        list.add(MovieContent(name = "Test2"))

        return list
    }
}
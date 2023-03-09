package com.example.leanbackplayground.movielistrecyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.leanbackplayground.Movie

class MovieViewHolder(private val view: MovieView) : RecyclerView.ViewHolder(view) {
    fun bind(item: Movie) {
        view.bind(item)
    }
}
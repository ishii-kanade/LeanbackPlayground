package com.example.leanbackplayground

import androidx.recyclerview.widget.RecyclerView

class MovieContentViewHolder(private val view: MovieContentView) : RecyclerView.ViewHolder(view) {
    fun bind(item: MovieContent) {
        view.bind(item)
    }
}
package com.example.leanbackplayground.movielist

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.leanbackplayground.Movie

class MovieListAdapter(
    private val context: Context,
    private val movieContents: List<Movie>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecyclerView.ViewHolder {
        val view = MovieView(context)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MovieViewHolder) {
            holder.bind(movieContents[position])
        }
    }

    override fun getItemCount(): Int {
        return movieContents.count()
    }
}
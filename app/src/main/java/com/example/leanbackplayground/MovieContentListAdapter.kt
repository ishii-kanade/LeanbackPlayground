package com.example.leanbackplayground

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MovieContentListAdapter(
    private val context: Context,
    private val movieContents: List<MovieContent>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecyclerView.ViewHolder {
        val view = MovieContentView(context)
        return MovieContentViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MovieContentViewHolder) {
            holder.bind(movieContents[position])
        }
    }

    override fun getItemCount(): Int {
        return movieContents.count()
    }
}
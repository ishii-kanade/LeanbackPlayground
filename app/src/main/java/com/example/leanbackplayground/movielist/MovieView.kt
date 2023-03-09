package com.example.leanbackplayground.movielist

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import com.example.leanbackplayground.Movie
import com.example.leanbackplayground.R

class MovieView constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private val textView: TextView

    init {
        val rootView =
            LayoutInflater.from(context).inflate(R.layout.movie_list_element, this)
        textView = rootView.findViewById(R.id.title_textview)
    }

    fun bind(item: Movie) {
        textView.text = item.title
    }
}
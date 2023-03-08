package com.example.leanbackplayground

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView

class MovieContentView constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private val textView: TextView

    init {
        val rootView =
            LayoutInflater.from(context).inflate(R.layout.movie_content_view_layout, this)
        textView = rootView.findViewById(R.id.text_test)
    }

    fun bind(item: MovieContent) {
        textView.text = item.name
    }
}
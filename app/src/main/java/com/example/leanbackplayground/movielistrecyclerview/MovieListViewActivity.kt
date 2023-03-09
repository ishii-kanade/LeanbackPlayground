package com.example.leanbackplayground.movielistrecyclerview

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.leanbackplayground.R

class MovieListViewActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.grid_view_fragment, MovieListViewFragment())
                .commitNow()
        }
    }
}
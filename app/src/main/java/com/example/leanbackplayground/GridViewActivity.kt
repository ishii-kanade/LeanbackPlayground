package com.example.leanbackplayground

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

class GridViewActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.grid_view_fragment, GridViewFragment())
                .commitNow()
        }
    }
}
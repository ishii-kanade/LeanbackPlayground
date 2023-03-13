package com.example.leanbackplayground.presenterselector

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.leanbackplayground.R

class VerticalGridSupportActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presenter_selector_example)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.presenter_selector_example_frame, VerticalGridSupportFragment())
                .commitNow()
        }
    }
}
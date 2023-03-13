package com.example.leanbackplayground.presenterselector

import android.os.Bundle
import android.util.Log
import androidx.leanback.app.VerticalGridSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.VerticalGridPresenter
import com.example.leanbackplayground.StringPresenter


class VerticalGridSupportFragment : VerticalGridSupportFragment() {
    private class Adapter(presenter: StringPresenter?) : ArrayObjectAdapter(presenter) {
        fun callNotifyChanged() {
            super.notifyChanged()
        }
    }

    private var mAdapter: Adapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "onCreate")
        super.onCreate(savedInstanceState)
//        setBadgeDrawable(getActivity()?.getResources()?.getDrawable(R.drawable.btn_default))
        title = "Leanback Vertical Grid Demo"
        setupFragment()
        if (TEST_ENTRANCE_TRANSITION) {
            // don't run entrance transition if fragment is restored.
            if (savedInstanceState == null) {
                prepareEntranceTransition()
            }
        }
        // simulates in a real world use case  data being loaded two seconds later
        loadData()
        startEntranceTransition()
    }

    private fun loadData() {
        for (i in 0 until NUM_ITEMS) {
            mAdapter?.add(Integer.toString(i))
        }
    }

    private fun setupFragment() {
        val gridPresenter = VerticalGridPresenter()
        gridPresenter.numberOfColumns = NUM_COLUMNS
        setGridPresenter(gridPresenter)
        mAdapter = Adapter(StringPresenter())
        adapter = mAdapter
        setOnItemViewSelectedListener { itemViewHolder, item, rowViewHolder, row ->
            Log.i(
                TAG,
                "onItemSelected: $item row $row"
            )
        }
//        setOnItemViewClickedListener(OnItemViewClickedListener { itemViewHolder, item, rowViewHolder, row ->
//            Log.i(
//                TAG,
//                "onItemClicked: $item row $row"
//            )
//            mAdapter.callNotifyChanged()
//        })
//        setOnSearchClickedListener(object : View.OnClickListener() {
//            fun onClick(view: View?) {
//                val intent = Intent(getActivity(), SearchSupportActivity::class.java)
//                startActivity(intent)
//            }
//        })
    }

    companion object {
        private const val TAG = "VerticalGrid Demo"
        private const val NUM_COLUMNS = 3
        private const val NUM_ITEMS = 50
        private const val HEIGHT = 200
        private const val TEST_ENTRANCE_TRANSITION = true
    }
}
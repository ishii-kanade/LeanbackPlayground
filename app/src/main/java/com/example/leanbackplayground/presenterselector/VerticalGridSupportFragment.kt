package com.example.leanbackplayground.presenterselector

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.leanback.app.VerticalGridSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.Presenter
import androidx.leanback.widget.PresenterSelector
import androidx.leanback.widget.VerticalGridPresenter
import com.example.leanbackplayground.*


class VerticalGridSupportFragment : VerticalGridSupportFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "onCreate")
        super.onCreate(savedInstanceState)
        title = "Leanback Vertical Grid Demo"
        setupFragment()
        if (TEST_ENTRANCE_TRANSITION) {
            // don't run entrance transition if fragment is restored.
            if (savedInstanceState == null) {
                prepareEntranceTransition()
            }
        }
        loadRows()
        startEntranceTransition()
    }

    private fun loadRows() {
        val cardPresenter = CardPresenter()
        val stringPresenter = StringPresenter()
        val presenters: Array<Presenter> = arrayOf(cardPresenter, stringPresenter)
        val presenterSelector = object : PresenterSelector() {
            override fun getPresenter(item: Any?): Presenter {
                if (item is Movie) {
                    return cardPresenter
                }
                if (item is String) {
                    return stringPresenter
                }
                throw IllegalArgumentException()
            }

            override fun getPresenters(): Array<Presenter> {
                return presenters
            }
        }
        val listRowAdapter = ArrayObjectAdapter(presenterSelector)
        listRowAdapter.add(MovieList.list[3])
        listRowAdapter.add(MovieList.list[4])
        listRowAdapter.add("dddsss")

        adapter = listRowAdapter
    }

    private fun setupFragment() {
        val gridPresenter = VerticalGridPresenter()
        gridPresenter.numberOfColumns = NUM_COLUMNS
        setGridPresenter(gridPresenter)
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
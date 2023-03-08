package com.example.leanbackplayground

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.leanback.widget.VerticalGridView
import androidx.lifecycle.ViewModelProvider

class GridViewFragment : Fragment() {
    private lateinit var viewModel: GridViewViewModel
    private lateinit var verticalGridView: VerticalGridView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[GridViewViewModel::class.java]
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_grid_view, container, false)
        verticalGridView = view.findViewById(R.id.vertical_grid_view)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MovieContentListAdapter(requireContext(), viewModel.createList())
        verticalGridView.setNumColumns(7)
        verticalGridView.adapter = adapter
    }
}
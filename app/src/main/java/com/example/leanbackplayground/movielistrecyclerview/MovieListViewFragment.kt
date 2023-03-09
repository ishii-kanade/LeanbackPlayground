package com.example.leanbackplayground.movielistrecyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.leanback.widget.VerticalGridView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.leanbackplayground.R

class MovieListViewFragment : Fragment() {
    private lateinit var viewModel: MovieListViewViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[MovieListViewViewModel::class.java]
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.recycler_movie_list, container, false)
        recyclerView = view.findViewById(R.id.recycler_view)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = GridLayoutManager(requireContext(), 7)
        recyclerView.layoutManager = layoutManager
        val adapter = MovieListAdapter(requireContext(), viewModel.createList())
//        recyclerView.setNumColumns(7)
        recyclerView.adapter = adapter
    }
}
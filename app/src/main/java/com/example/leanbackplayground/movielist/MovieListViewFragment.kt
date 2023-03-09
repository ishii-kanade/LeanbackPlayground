package com.example.leanbackplayground.movielist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.leanbackplayground.R

class MovieListViewFragment : Fragment() {
    private lateinit var viewModel: MovieListViewViewModel
    private lateinit var verticalGridView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[MovieListViewViewModel::class.java]
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.movie_list, container, false)
        verticalGridView = view.findViewById(R.id.vertical_grid_view)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = GridLayoutManager(requireContext(), 5)
        verticalGridView.layoutManager = layoutManager
        val adapter = MovieListAdapter(requireContext(), viewModel.createList())
        verticalGridView.adapter = adapter
    }
}
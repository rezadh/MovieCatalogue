package com.rezadev.moviecatalogue.ui.movietv

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rezadev.moviecatalogue.R
import com.rezadev.moviecatalogue.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_movie_tv.*

class MovieTvFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_movie_tv, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MovieTvViewModel::class.java]
            val movieTvAdapter = MovieTvAdapter()
            progress_bar_tv.visibility = View.VISIBLE
            viewModel.getMoviesTv().observe(this, { moviesTv ->
                progress_bar_tv.visibility = View.GONE
                movieTvAdapter.setMovieTv(moviesTv)
                movieTvAdapter.notifyDataSetChanged()
            })

            with(rv_movies_tv){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieTvAdapter
            }
        }
    }
}
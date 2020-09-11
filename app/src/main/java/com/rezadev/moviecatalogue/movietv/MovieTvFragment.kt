package com.rezadev.moviecatalogue.movietv

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rezadev.moviecatalogue.R
import kotlinx.android.synthetic.main.fragment_movie_tv.*

class MovieTvFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_movie_tv, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MovieTvViewModel::class.java]
            val movies = viewModel.getMoviesTv()
            val movieTvAdapter = MovieTvAdapter()
            movieTvAdapter.setMovieTv(movies)
            with(rv_movies_tv){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieTvAdapter
            }
        }
    }
}
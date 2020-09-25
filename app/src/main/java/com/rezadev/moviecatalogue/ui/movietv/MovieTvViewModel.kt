package com.rezadev.moviecatalogue.ui.movietv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rezadev.moviecatalogue.data.source.MovieRepository
import com.rezadev.moviecatalogue.data.source.local.entity.MovieTvEntity

class MovieTvViewModel (private val movieRepository: MovieRepository) : ViewModel() {
    fun getMoviesTv() : LiveData<List<MovieTvEntity>> = movieRepository.getMoviesTv()
}
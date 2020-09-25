package com.rezadev.moviecatalogue.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rezadev.moviecatalogue.data.source.MovieRepository
import com.rezadev.moviecatalogue.data.source.local.entity.MovieEntity

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getMovies(): LiveData<List<MovieEntity>> = movieRepository.getMovies()
}
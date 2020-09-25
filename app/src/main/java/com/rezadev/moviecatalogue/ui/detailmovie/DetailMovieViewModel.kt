package com.rezadev.moviecatalogue.ui.detailmovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rezadev.moviecatalogue.data.source.MovieRepository
import com.rezadev.moviecatalogue.data.source.local.entity.MovieEntity

class DetailMovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    private var movieId : Int = 0

    fun selectedMovie(movieId : Int){
        this.movieId = movieId
    }

    fun getMovie() : LiveData<MovieEntity> = movieRepository.getMovie(movieId)
}
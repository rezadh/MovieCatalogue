package com.rezadev.moviecatalogue.ui.detailmovietv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rezadev.moviecatalogue.data.source.MovieRepository
import com.rezadev.moviecatalogue.data.source.local.entity.MovieTvEntity


class DetailMovieTvViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    private  var movieTvId : Int = 0

    fun selectedMovieTv(movieTvId : Int){
        this.movieTvId = movieTvId
    }

    fun getMovieTv() : LiveData<MovieTvEntity> = movieRepository.getMovieTv(movieTvId)
}
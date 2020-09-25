package com.rezadev.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import com.rezadev.moviecatalogue.data.source.local.entity.MovieEntity
import com.rezadev.moviecatalogue.data.source.local.entity.MovieTvEntity

interface MovieDataSource {
    fun getMovies(): LiveData<List<MovieEntity>>

    fun getMovie(movieId: Int): LiveData<MovieEntity>

    fun getMoviesTv(): LiveData<List<MovieTvEntity>>

    fun getMovieTv(movieTvId: Int): LiveData<MovieTvEntity>
}
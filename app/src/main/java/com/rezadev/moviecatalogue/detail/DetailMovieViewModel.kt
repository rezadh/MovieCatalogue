package com.rezadev.moviecatalogue.detail

import androidx.lifecycle.ViewModel
import com.rezadev.moviecatalogue.data.source.local.entity.MovieEntity
import com.rezadev.moviecatalogue.data.source.local.entity.MovieTvEntity
import com.rezadev.moviecatalogue.utils.DataDummy

class DetailMovieViewModel : ViewModel() {
    private lateinit var movieId : String
    private lateinit var movieTvId : String

    fun selectedMovie(movieId : String){
        this.movieId = movieId
    }

    fun selectedMovieTv(movieTvId : String){
        this.movieTvId = movieTvId
    }

    fun getMovie() : MovieEntity? {
        var movies : MovieEntity? = null
        val movieEntities = DataDummy.generateDummyMovie()
        for (movieEntity in movieEntities){
            if (movieEntity.movieId == movieId){
                movies = movieEntity
            }
        }
        return movies
    }

    fun getMovieTv() : MovieTvEntity? {
        var moviesTv : MovieTvEntity? = null
        val movieTvEntities = DataDummy.generateDummyMovieTv()
        for (movieTvEntity in movieTvEntities){
            if (movieTvEntity.movieTvId == movieTvId){
                moviesTv = movieTvEntity
            }
        }
        return moviesTv
    }
}
package com.rezadev.moviecatalogue.data.source.remote

import android.os.Handler
import com.rezadev.moviecatalogue.data.source.remote.response.MovieResponse
import com.rezadev.moviecatalogue.data.source.remote.response.MovieTvResponse
import com.rezadev.moviecatalogue.utils.EspressoIdlingResource
import com.rezadev.moviecatalogue.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper : JsonHelper){
    private val handler = Handler()

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS : Long = 2000
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper)
            }
    }

    fun getMovieResponseList(callback: LoadMoviesCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onMoviesReceived(jsonHelper.loadMovieList())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getMovieTvResponseList(callback: LoadMoviesTvCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onMoviesTvReceived(jsonHelper.loadMovieTvList())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getMovieResponse(movieId: Int, callback: LoadMovieCallback){
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onMovieReceived(jsonHelper.loadMovieResponse(movieId))
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getMovieTvResponse(movieId: Int, callback: LoadMovieTvCallback){
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onMovieTvReceived(jsonHelper.loadMovieTvResponse(movieId))
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    interface LoadMoviesCallback {
        fun onMoviesReceived(movieResponseList: List<MovieResponse>)
    }
    interface LoadMovieCallback {
        fun onMovieReceived(movieResponse: MovieResponse)
    }
    interface LoadMoviesTvCallback {
        fun onMoviesTvReceived(movieTvResponseList: List<MovieTvResponse>)
    }
    interface LoadMovieTvCallback {
        fun onMovieTvReceived(movieTvResponse: MovieTvResponse)
    }
}
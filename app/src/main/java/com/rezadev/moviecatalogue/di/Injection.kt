package com.rezadev.moviecatalogue.di

import android.content.Context
import com.rezadev.moviecatalogue.data.source.MovieRepository
import com.rezadev.moviecatalogue.data.source.remote.RemoteDataSource
import com.rezadev.moviecatalogue.utils.JsonHelper

object Injection {
    fun provideMovieRepository(context : Context) : MovieRepository {
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        return MovieRepository.getInstance(remoteDataSource)
    }
}
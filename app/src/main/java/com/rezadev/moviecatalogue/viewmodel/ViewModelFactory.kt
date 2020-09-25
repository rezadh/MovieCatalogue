package com.rezadev.moviecatalogue.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rezadev.moviecatalogue.data.source.MovieRepository
import com.rezadev.moviecatalogue.ui.detailmovie.DetailMovieViewModel
import com.rezadev.moviecatalogue.ui.detailmovietv.DetailMovieTvViewModel
import com.rezadev.moviecatalogue.di.Injection
import com.rezadev.moviecatalogue.ui.movie.MovieViewModel
import com.rezadev.moviecatalogue.ui.movietv.MovieTvViewModel

class ViewModelFactory private constructor(private val mMovieRepository: MovieRepository) : ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideMovieRepository(context))
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(MovieTvViewModel::class.java) -> {
                MovieTvViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                DetailMovieViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(DetailMovieTvViewModel::class.java) -> {
                DetailMovieTvViewModel(mMovieRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}
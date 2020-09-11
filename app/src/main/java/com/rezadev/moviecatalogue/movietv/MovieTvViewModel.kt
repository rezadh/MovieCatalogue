package com.rezadev.moviecatalogue.movietv

import androidx.lifecycle.ViewModel
import com.rezadev.moviecatalogue.data.source.local.entity.MovieTvEntity
import com.rezadev.moviecatalogue.utils.DataDummy

class MovieTvViewModel : ViewModel() {
    fun getMoviesTv() : List<MovieTvEntity> = DataDummy.generateDummyMovieTv()
}
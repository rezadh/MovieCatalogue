package com.rezadev.moviecatalogue.detail

import com.rezadev.moviecatalogue.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val movie = DataDummy.generateDummyMovie()[0]
    private val movieTv = DataDummy.generateDummyMovieTv()[0]
    private val movieId = movie.movieId
    private val movieTvId = movieTv.movieTvId

    @Before
    fun setUpDetailMovie(){
        viewModel = DetailMovieViewModel()
        viewModel.selectedMovie(movieId)
        viewModel.selectedMovieTv(movieTvId)
    }

    @Test
    fun getMovie() {
        viewModel.selectedMovie(movie.movieId)
        val movieEntity = viewModel.getMovie()
        assertNotNull(movieEntity)
        if (movieEntity != null){
            assertEquals(movie.movieId, movieEntity.movieId)
            assertEquals(movie.title, movieEntity.title)
            assertEquals(movie.overview, movieEntity.overview)
            assertEquals(movie.releaseDate, movieEntity.releaseDate)
            assertEquals(movie.director, movieEntity.director)
            assertEquals(movie.genre, movieEntity.genre)

        }
    }

    @Test
    fun getMovieTv() {
        viewModel.selectedMovie(movieTvId)
        val movieTvEntity = viewModel.getMovieTv()
        assertNotNull(movieTvEntity)
        if (movieTvEntity != null){
            assertEquals(movieTv.movieTvId, movieTvEntity.movieTvId)
            assertEquals(movieTv.title, movieTvEntity.title)
            assertEquals(movieTv.overview, movieTvEntity.overview)
            assertEquals(movieTv.releaseDate, movieTvEntity.releaseDate)
            assertEquals(movieTv.creator, movieTvEntity.creator)
            assertEquals(movieTv.genre, movieTvEntity.genre)
        }
    }
}
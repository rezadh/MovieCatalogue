package com.rezadev.moviecatalogue.ui.detailmovie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.rezadev.moviecatalogue.data.source.FakeMovieRepository
import com.rezadev.moviecatalogue.data.source.MovieRepository
import com.rezadev.moviecatalogue.data.source.local.entity.MovieEntity
import com.rezadev.moviecatalogue.utils.DataDummy
import com.rezadev.moviecatalogue.utils.FakeDataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovie()[0]
    private val movieId = dummyMovie.movieId


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var detailMovieObserver: Observer<MovieEntity>


    @Before
    fun setUpDetailMovie(){
        viewModel = DetailMovieViewModel(movieRepository)
        viewModel.selectedMovie(movieId)
    }

    @Test
    fun getMovie() {
        val movieMutable = MutableLiveData<MovieEntity>()
        movieMutable.value = dummyMovie
        `when`(movieRepository.getMovie(movieId)).thenReturn(movieMutable)
        val movieEntity = viewModel.getMovie().value as MovieEntity
        verify(movieRepository).getMovie(movieId)
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.movieId, movieEntity.movieId)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.releaseDate, movieEntity.releaseDate)
        assertEquals(dummyMovie.genre, movieEntity.genre)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.imagePath, movieEntity.imagePath)
        assertEquals(dummyMovie.director, movieEntity.director)
        viewModel.getMovie().observeForever(detailMovieObserver)
        verify(detailMovieObserver).onChanged(dummyMovie)
    }
}
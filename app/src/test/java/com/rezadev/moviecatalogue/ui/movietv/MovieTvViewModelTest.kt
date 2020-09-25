package com.rezadev.moviecatalogue.ui.movietv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.rezadev.moviecatalogue.data.source.FakeMovieRepository
import com.rezadev.moviecatalogue.data.source.MovieRepository
import com.rezadev.moviecatalogue.data.source.local.entity.MovieTvEntity
import com.rezadev.moviecatalogue.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieTvViewModelTest {
    private lateinit var viewModel: MovieTvViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<List<MovieTvEntity>>
    @Before
    fun setUp() {
        viewModel = MovieTvViewModel(movieRepository)
    }
    @Test
    fun getMoviesTv() {
        val dummyMovieTv = DataDummy.generateDummyMovieTv()
        val movieTvMutable = MutableLiveData<List<MovieTvEntity>>()
        movieTvMutable.value = dummyMovieTv

        `when`(movieRepository.getMoviesTv()).thenReturn(movieTvMutable)
        val movieTvEntities = viewModel.getMoviesTv()
        verify(movieRepository).getMoviesTv()
        assertNotNull(movieTvEntities)

        viewModel.getMoviesTv().observeForever(observer)
        verify(observer).onChanged(dummyMovieTv)
    }
}
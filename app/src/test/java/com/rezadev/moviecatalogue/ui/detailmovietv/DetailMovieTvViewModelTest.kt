package com.rezadev.moviecatalogue.ui.detailmovietv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.rezadev.moviecatalogue.data.source.FakeMovieRepository
import com.rezadev.moviecatalogue.data.source.MovieRepository
import com.rezadev.moviecatalogue.data.source.local.entity.MovieTvEntity
import com.rezadev.moviecatalogue.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieTvViewModelTest {

    private lateinit var viewModel: DetailMovieTvViewModel
    private val movie = DataDummy.generateDummyMovie()[0]
    private val movieTv = DataDummy.generateDummyMovieTv()[0]
    private val movieId = movie.movieId
    private val movieTvId = movieTv.movieTvId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var detailMovieTvObserver: Observer<MovieTvEntity>

    @Before
    fun setUpDetailMovie(){
        viewModel = DetailMovieTvViewModel(movieRepository)
        viewModel.selectedMovieTv(movieTvId)
    }

    @Test
    fun getMovieTv() {
        val movieTvMutable = MutableLiveData<MovieTvEntity>()
        movieTvMutable.value = movieTv
        `when`(movieRepository.getMovieTv(movieTvId)).thenReturn(movieTvMutable)
        val movieTvEntity = viewModel.getMovieTv().value as MovieTvEntity
        verify(movieRepository).getMovieTv(movieTvId)
        assertNotNull(movieTvEntity)
        assertEquals(movieTv.movieTvId, movieTvEntity.movieTvId)
        assertEquals(movieTv.title, movieTvEntity.title)
        assertEquals(movieTv.overview, movieTvEntity.overview)
        assertEquals(movieTv.releaseDate, movieTvEntity.releaseDate)
        assertEquals(movieTv.creator, movieTvEntity.creator)
        assertEquals(movieTv.genre, movieTvEntity.genre)
        viewModel.getMovieTv().observeForever(detailMovieTvObserver)
        verify(detailMovieTvObserver).onChanged(movieTv)
    }
}
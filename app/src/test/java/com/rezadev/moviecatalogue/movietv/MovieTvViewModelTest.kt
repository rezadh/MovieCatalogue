package com.rezadev.moviecatalogue.movietv

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MovieTvViewModelTest {
    private lateinit var viewModel: MovieTvViewModel

    @Before
    fun setUp() {
        viewModel = MovieTvViewModel()
    }
    @Test
    fun getMoviesTv() {
        val movieTvEntities = viewModel.getMoviesTv()
        assertNotNull(movieTvEntities)
        assertEquals(10, movieTvEntities.size)
    }
}
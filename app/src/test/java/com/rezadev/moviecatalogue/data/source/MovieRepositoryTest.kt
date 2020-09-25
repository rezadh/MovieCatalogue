package com.rezadev.moviecatalogue.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.rezadev.moviecatalogue.data.source.remote.RemoteDataSource
import com.rezadev.moviecatalogue.utils.FakeDataDummy
import com.rezadev.moviecatalogue.utils.LiveDataTestUtil
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.verify

class MovieRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val movieRepository = FakeMovieRepository(remote)

    private val movieResponseList = FakeDataDummy.generateDummyMovie()
    private val idMovieResponse = movieResponseList[0].movieId
    private val movieResponse = FakeDataDummy.getMovieById(idMovieResponse)

    private val movieTvResponseList = FakeDataDummy.generateDummyMovieTv()
    private val idMovieTvResponse = movieTvResponseList[0].movieTvId
    private val movieTvResponse = FakeDataDummy.getMovieTvById(idMovieTvResponse)

    @Test
    fun getMoviesList() {
//        `when`<List<MovieResponse>>(remote.getMovieResponseList()).thenReturn(movieResponseList)
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onMoviesReceived(movieResponseList)
            null
        }.`when`(remote).getMovieResponseList(any())
        val movieEntities = LiveDataTestUtil.getValue(movieRepository.getMovies())
        verify(remote).getMovieResponseList(any())
        assertNotNull(movieEntities)
        assertEquals(movieResponseList.size.toLong(), movieEntities.size.toLong())
    }
    @Test
    fun getMovie() {
        doAnswer { invocation ->
            movieResponse?.let {
                (invocation.arguments[1] as RemoteDataSource.LoadMovieCallback)
                    .onMovieReceived(it)
                null }
        }.`when`(remote).getMovieResponse(
            eq(idMovieResponse),
            any())
        val movieEntities = LiveDataTestUtil.getValue(movieRepository.getMovie(idMovieResponse))
        verify(
            remote)
            .getMovieResponse(eq(idMovieResponse),
            any())
        assertNotNull(movieEntities)
        assertEquals(movieResponse?.movieId, 1)
    }

    @Test
    fun getMovieTvList() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesTvCallback)
                .onMoviesTvReceived(movieTvResponseList)
            null
        }.`when`(remote).getMovieTvResponseList(any())
        val movieTvEntities = LiveDataTestUtil.getValue(movieRepository.getMoviesTv())
        verify(remote).getMovieTvResponseList(any())
        assertNotNull(movieTvEntities)
        assertEquals(movieTvResponseList.size.toLong(), movieTvEntities.size.toLong())
    }

    @Test
    fun getMovieTv() {
        doAnswer { invocation ->
            movieTvResponse?.let {
                (invocation.arguments[1] as RemoteDataSource.LoadMovieTvCallback)
                    .onMovieTvReceived(it)
                null }
        }.`when`(remote).getMovieTvResponse(
            eq(idMovieTvResponse),
            any())
        val movieTvEntities = LiveDataTestUtil.getValue(movieRepository.getMovieTv(idMovieTvResponse))
        verify(
            remote)
            .getMovieTvResponse(eq(idMovieTvResponse),
                any())
        assertNotNull(movieTvEntities)
        assertEquals(movieTvResponse?.movieTvId, 1)
    }
}
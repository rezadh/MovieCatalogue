package com.rezadev.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rezadev.moviecatalogue.data.source.local.entity.MovieEntity
import com.rezadev.moviecatalogue.data.source.local.entity.MovieTvEntity
import com.rezadev.moviecatalogue.data.source.remote.RemoteDataSource
import com.rezadev.moviecatalogue.data.source.remote.response.MovieResponse
import com.rezadev.moviecatalogue.data.source.remote.response.MovieTvResponse

class MovieRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    MovieDataSource {

    companion object {
        @Volatile
        private var instance: MovieRepository? = null

        fun getInstance(remoteData: RemoteDataSource) : MovieRepository =
            instance ?: synchronized(this){
                instance ?: MovieRepository(remoteData)
            }
    }
    override fun getMovies(): LiveData<List<MovieEntity>> {
        val moviesMutable = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getMovieResponseList(object : RemoteDataSource.LoadMoviesCallback {
            override fun onMoviesReceived(movieResponseList: List<MovieResponse>) {
                val movies = ArrayList<MovieEntity>()
                for (response in movieResponseList){
                    val movie = MovieEntity(
                        response.movieId,
                        response.title,
                        response.overview,
                        response.releaseDate,
                        response.director,
                        response.genre,
                        response.imagePath
                    )
                    movies.add(movie)
                }
                moviesMutable.postValue(movies)
            }
        })
        return moviesMutable
    }

    override fun getMovie(movieId: Int): LiveData<MovieEntity> {
        val movieMutable = MutableLiveData<MovieEntity>()
        remoteDataSource.getMovieResponse(movieId, object : RemoteDataSource.LoadMovieCallback{
            override fun onMovieReceived(movieResponse: MovieResponse) {
                val movie = MovieEntity(
                    movieResponse.movieId,
                    movieResponse.title,
                    movieResponse.overview,
                    movieResponse.releaseDate,
                    movieResponse.director,
                    movieResponse.genre,
                    movieResponse.imagePath
                )
                movieMutable.postValue(movie)
            }
        })
        return movieMutable
    }

    override fun getMoviesTv(): LiveData<List<MovieTvEntity>> {
        val moviesTvMutable = MutableLiveData<List<MovieTvEntity>>()

        remoteDataSource.getMovieTvResponseList(object : RemoteDataSource.LoadMoviesTvCallback{
            override fun onMoviesTvReceived(movieTvResponseList: List<MovieTvResponse>) {
                val moviesTv = ArrayList<MovieTvEntity>()
                for(response in movieTvResponseList){
                    val movieTv = MovieTvEntity(
                        response.movieTvId,
                        response.title,
                        response.overview,
                        response.releaseDate,
                        response.creator,
                        response.genre,
                        response.imagePath
                    )
                    moviesTv.add(movieTv)
                }
                moviesTvMutable.postValue(moviesTv)
            }
        })
        return moviesTvMutable
    }

    override fun getMovieTv(movieTvId: Int): LiveData<MovieTvEntity> {
        val movieTvMutable = MutableLiveData<MovieTvEntity>()
        remoteDataSource.getMovieTvResponse(movieTvId, object : RemoteDataSource.LoadMovieTvCallback{
            override fun onMovieTvReceived(movieTvResponse: MovieTvResponse) {
                val movieTv = MovieTvEntity(
                    movieTvResponse.movieTvId,
                    movieTvResponse.title,
                    movieTvResponse.overview,
                    movieTvResponse.releaseDate,
                    movieTvResponse.creator,
                    movieTvResponse.genre,
                    movieTvResponse.imagePath
                )
                movieTvMutable.postValue(movieTv)
            }
        })
        return movieTvMutable
    }

}
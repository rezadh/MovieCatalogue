package com.rezadev.moviecatalogue.utils

import android.content.Context
import com.rezadev.moviecatalogue.data.source.remote.response.MovieResponse
import com.rezadev.moviecatalogue.data.source.remote.response.MovieTvResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper (private val context: Context) {
    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovieList() : List<MovieResponse> {
        val list = ArrayList<MovieResponse>()

        try {
            val responseObject = JSONObject(parsingFileToString("movie.json").toString())
            val listArray = responseObject.getJSONArray("movie")
            for (i in 0 until listArray.length()){
                val movie = listArray.getJSONObject(i)

                val id = movie.getInt("id")
                val title = movie.getString("title")
                val overview = movie.getString("overview")
                val releaseDate = movie.getString("release_date")
                val director = movie.getString("director")
                val genre = movie.getString("genre")
                val image = movie.getString("image")

                val courseResponse = MovieResponse(id, title, overview, releaseDate, director, genre, image)
                list.add(courseResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }


    fun loadMovieTvList() : List<MovieTvResponse> {
        val list = ArrayList<MovieTvResponse>()

        try {
            val responseObject = JSONObject(parsingFileToString("tvShow.json").toString())
            val listArray = responseObject.getJSONArray("tvShow")
            for (i in 0 until listArray.length()){
                val movie = listArray.getJSONObject(i)

                val id = movie.getInt("id")
                val title = movie.getString("title")
                val overview = movie.getString("overview")
                val releaseDate = movie.getString("release_date")
                val creator = movie.getString("creator")
                val genre = movie.getString("genre")
                val image = movie.getString("image")

                val courseResponse = MovieTvResponse(id, title, overview, releaseDate, creator, genre, image)
                list.add(courseResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadMovieResponse(movieId: Int): MovieResponse {
        val fileName = String.format("movie_%s.json", movieId)
        var movieResponse = MovieResponse()
        try {
            val result = parsingFileToString(fileName)
            if (result != null) {
                val responseObject = JSONObject(result)

                val id = responseObject.getInt("id")
                val title = responseObject.getString("title")
                val overview = responseObject.getString("overview")
                val releaseDate = responseObject.getString("release_date")
                val director = responseObject.getString("director")
                val genre = responseObject.getString("genre")
                val image = responseObject.getString("image")

                movieResponse = MovieResponse(id, title, overview, releaseDate, director, genre, image)

            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return movieResponse

    }

    fun loadMovieTvResponse(movieTvId: Int): MovieTvResponse {
        val fileName = String.format("tvShow_%s.json", movieTvId)
        var movieTvResponse = MovieTvResponse()
        try {
            val result = parsingFileToString(fileName)
            if (result != null) {
                val responseObject = JSONObject(result)

                val id = responseObject.getInt("id")
                val title = responseObject.getString("title")
                val overview = responseObject.getString("overview")
                val releaseDate = responseObject.getString("release_date")
                val creator = responseObject.getString("creator")
                val genre = responseObject.getString("genre")
                val image = responseObject.getString("image")

                movieTvResponse = MovieTvResponse(id, title, overview, releaseDate, creator, genre, image)

            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return movieTvResponse

    }
}
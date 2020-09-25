package com.rezadev.moviecatalogue.data.source.remote.response

data class MovieResponse (
    val movieId: Int = 0,
    val title: String = "",
    val overview: String = "",
    val releaseDate: String = "",
    val director: String = "",
    val genre: String = "",
    val imagePath: String = ""
)
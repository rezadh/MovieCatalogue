package com.rezadev.moviecatalogue.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rezadev.moviecatalogue.R
import com.rezadev.moviecatalogue.data.source.local.entity.MovieEntity
import com.rezadev.moviecatalogue.data.source.local.entity.MovieTvEntity
import kotlinx.android.synthetic.main.activity_detail_movie.*
import kotlinx.android.synthetic.main.content_detail_movie.*

class DetailMovieActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_MOVIE_TV = "extra_movie_tv"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailMovieViewModel::class.java]
        val extras = intent.extras
        if (extras != null){
            val movieId = extras.getString(EXTRA_MOVIE)
            val movieTvId = extras.getString(EXTRA_MOVIE_TV)
            when {
                movieId != null -> {
                    viewModel.selectedMovie(movieId)
                    viewModel.getMovie()?.let { populateMovie(it) }
                }
                movieTvId != null -> {
                    viewModel.selectedMovieTv(movieTvId)
                    viewModel.getMovieTv()?.let { populateMovieTv(it) }
                }
            }
        }
    }
    private fun populateMovie(movieEntity: MovieEntity){
        text_title.text = movieEntity.title
        text_genre.text = movieEntity.genre
        text_date.text = movieEntity.releaseDate
        tv_director.text = movieEntity.director
        tv_overview.text = movieEntity.overview

        Glide.with(this)
            .load(movieEntity.imagePath)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
            .error(R.drawable.ic_error)
            .into(image_poster)
    }

    private fun populateMovieTv(movieTvEntity: MovieTvEntity){
        text_title.text = movieTvEntity.title
        text_genre.text = movieTvEntity.genre
        text_date.text = movieTvEntity.releaseDate
        text_director.text = StringBuilder("creator")
        tv_director.text = movieTvEntity.creator
        tv_overview.text = movieTvEntity.overview

        Glide.with(this)
            .load(movieTvEntity.imagePath)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
            .error(R.drawable.ic_error)
            .into(image_poster)
    }
}
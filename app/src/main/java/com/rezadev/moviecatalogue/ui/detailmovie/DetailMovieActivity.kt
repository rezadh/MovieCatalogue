package com.rezadev.moviecatalogue.ui.detailmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rezadev.moviecatalogue.R
import com.rezadev.moviecatalogue.data.source.local.entity.MovieEntity
import com.rezadev.moviecatalogue.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_detail_movie.*
import kotlinx.android.synthetic.main.content_detail_movie.*


class DetailMovieActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_MOVIE = "extra_movie"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null){
            val movieId = extras.getInt(EXTRA_MOVIE)
            viewModel.selectedMovie(movieId)
                    progress_bar_content.visibility = View.VISIBLE
            viewModel.getMovie().observe(this, { movies ->
                        progress_bar_content.visibility = View.GONE
                populateMovie(movies)
            })
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
}
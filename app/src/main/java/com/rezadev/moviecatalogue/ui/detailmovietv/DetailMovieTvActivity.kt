package com.rezadev.moviecatalogue.ui.detailmovietv

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rezadev.moviecatalogue.R
import com.rezadev.moviecatalogue.data.source.local.entity.MovieTvEntity
import com.rezadev.moviecatalogue.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_detail_movie.*
import kotlinx.android.synthetic.main.content_detail_movie.*
import java.lang.StringBuilder

class DetailMovieTvActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_MOVIE_TV = "extra_movie_tv"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailMovieTvViewModel::class.java]

        val extras = intent.extras
        if (extras != null){
            val movieTvId = extras.getInt(EXTRA_MOVIE_TV)
            viewModel.selectedMovieTv(movieTvId)
            progress_bar_content.visibility = View.VISIBLE
            viewModel.getMovieTv().observe(this, { moviesTv ->
                progress_bar_content.visibility = View.GONE
                populateMovieTv(moviesTv)
            })
        }
    }

    private fun populateMovieTv(movieTvEntity: MovieTvEntity){
        text_title.text = movieTvEntity.title
        text_genre.text = movieTvEntity.genre
        text_date.text = movieTvEntity.releaseDate
        tv_director.text = movieTvEntity.creator
        tv_overview.text = movieTvEntity.overview
        text_director.text = StringBuilder("creator")
        Glide.with(this)
            .load(movieTvEntity.imagePath)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
            .error(R.drawable.ic_error)
            .into(image_poster)
    }
}
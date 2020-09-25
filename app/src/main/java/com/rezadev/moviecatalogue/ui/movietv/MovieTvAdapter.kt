package com.rezadev.moviecatalogue.ui.movietv

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rezadev.moviecatalogue.R
import com.rezadev.moviecatalogue.data.source.local.entity.MovieTvEntity
import com.rezadev.moviecatalogue.ui.detailmovietv.DetailMovieTvActivity
import kotlinx.android.synthetic.main.items_movie_tv.view.*

class MovieTvAdapter : RecyclerView.Adapter<MovieTvAdapter.MovieTvViewHolder>() {
    private val listMovieTv = ArrayList<MovieTvEntity>()

    fun setMovieTv(moviesTv: List<MovieTvEntity>?) {
        if (moviesTv == null) return
        this.listMovieTv.clear()
        this.listMovieTv.addAll(moviesTv)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieTvViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_movie_tv, parent,false)
        return MovieTvViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieTvViewHolder, position: Int) {
        val movie = listMovieTv[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovieTv.size

    class MovieTvViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(movieTv : MovieTvEntity){
            with(itemView){
                tv_item_title.text = movieTv.title
                tv_item_genre.text = movieTv.genre
                tv_item_date.text = movieTv.releaseDate

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieTvActivity::class.java)
                    intent.putExtra(DetailMovieTvActivity.EXTRA_MOVIE_TV, movieTv.movieTvId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(movieTv.imagePath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                    .fitCenter()
                    .into(img_poster)
            }
        }

    }


}
package com.ivash.movieapp.movieList

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ivash.movieapp.R
import com.ivash.movieapp.databinding.ViewHolderMovieBinding
import com.ivash.movieapp.model.MovieData

class MovieListAdapter : ListAdapter<MovieData, MovieListAdapter.ViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
            .from(parent.context)
            .inflate(R.layout.view_holder_movie, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val viewHolderBinding by viewBinding(ViewHolderMovieBinding::bind)
        private val movieImage: ImageView = viewHolderBinding.movieCardImage
        private val likeImage: ImageView = viewHolderBinding.likeImage
        private val ageLimitText: TextView = viewHolderBinding.ageLimitText
        private val genreText: TextView = viewHolderBinding.movieGenreText
        private val starsImages: List<ImageView> = listOf(
            viewHolderBinding.ratingStar1Image,
            viewHolderBinding.ratingStar2Image,
            viewHolderBinding.ratingStar3Image,
            viewHolderBinding.ratingStar4Image,
            viewHolderBinding.ratingStar5Image
        )
        private val reviewsText: TextView = viewHolderBinding.movieCardReviewsText
        private val movieTitle: TextView = viewHolderBinding.movieCardTitle
        private val movieLength: TextView = viewHolderBinding.movieLength

        fun bind(movieData: MovieData) {

            movieImage.setImageResource(movieData.image)
            ageLimitText.text = movieData.ageLimit.toString()

            val likeColor = if (movieData.isLiked) R.color.pink else R.color.white
            ImageViewCompat.setImageTintList(
                likeImage, ColorStateList.valueOf(
                    ContextCompat.getColor(likeImage.context, likeColor)
                )
            )

            starsImages.forEachIndexed { index, imageView ->
                val starColor = if (movieData.rating > index) R.color.pink else R.color.light_gray
                ImageViewCompat.setImageTintList(
                    imageView, ColorStateList.valueOf(
                        ContextCompat.getColor(imageView.context, starColor)
                    )
                )
            }

            genreText.text = movieData.genre
            reviewsText.text =
                itemView.context.getString(R.string.movie_reviews, movieData.reviewsCount)
            movieTitle.text = movieData.title
            movieLength.text =
                itemView.context.getString(R.string.movie_length, movieData.movieLength)
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<MovieData>() {
        override fun areItemsTheSame(oldItem: MovieData, newItem: MovieData): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: MovieData, newItem: MovieData): Boolean {
            return oldItem == newItem
        }
    }
}
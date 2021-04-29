package com.ivash.movieapp.movieList

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ivash.movieapp.R
import com.ivash.movieapp.databinding.ViewHolderMovieBinding
import com.ivash.movieapp.model.MovieData

class MovieListAdapter(private val onClick: (MovieData) -> Unit) :
    ListAdapter<MovieData, MovieListAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_holder_movie, parent, false),
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, onClick)
    }

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val viewHolderBinding by viewBinding(ViewHolderMovieBinding::bind)
        private val starsImages: List<ImageView> = listOf(
            viewHolderBinding.ratingStar1Image,
            viewHolderBinding.ratingStar2Image,
            viewHolderBinding.ratingStar3Image,
            viewHolderBinding.ratingStar4Image,
            viewHolderBinding.ratingStar5Image
        )

        fun bind(movieData: MovieData, onClick: (MovieData) -> Unit) {

            viewHolderBinding.movieCardImage.setImageResource(movieData.imageResId)
            viewHolderBinding.ageLimitText.text =
                itemView.context.getString(R.string.age_limit, movieData.ageLimit)

            @ColorRes
            val likeColorResId = if (movieData.isLiked) R.color.pink else R.color.white
            ImageViewCompat.setImageTintList(
                viewHolderBinding.likeImage, ColorStateList.valueOf(
                    ContextCompat.getColor(viewHolderBinding.likeImage.context, likeColorResId)
                )
            )

            starsImages.forEachIndexed { index, imageView ->
                @ColorRes
                val starColorResId =
                    if (movieData.rating > index) R.color.pink else R.color.light_gray
                ImageViewCompat.setImageTintList(
                    imageView, ColorStateList.valueOf(
                        ContextCompat.getColor(imageView.context, starColorResId)
                    )
                )
            }

            viewHolderBinding.movieGenreText.text = movieData.genre
            viewHolderBinding.movieCardReviewsText.text =
                itemView.context.getString(R.string.movie_reviews, movieData.reviewsCount)
            viewHolderBinding.movieCardTitle.text = movieData.title
            viewHolderBinding.movieLength.text =
                itemView.context.getString(R.string.movie_length, movieData.movieLength)
            itemView.setOnClickListener { onClick(movieData) }
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<MovieData>() {
        override fun areItemsTheSame(oldItem: MovieData, newItem: MovieData): Boolean =
            oldItem.title == newItem.title


        override fun areContentsTheSame(oldItem: MovieData, newItem: MovieData): Boolean =
            oldItem == newItem
    }
}
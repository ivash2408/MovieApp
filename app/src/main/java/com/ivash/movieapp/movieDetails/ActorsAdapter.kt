package com.ivash.movieapp.movieDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ivash.movieapp.R
import com.ivash.movieapp.databinding.ViewHolderActorBinding
import com.ivash.movieapp.model.ActorData

class ActorsAdapter : ListAdapter<ActorData, ActorsAdapter.ViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_holder_actor, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private val viewHolderBinding by viewBinding(ViewHolderActorBinding::bind)

        fun bind(actorData: ActorData) {
            viewHolderBinding.castText.text = actorData.name
            viewHolderBinding.castImage.setImageResource(actorData.actorPhoto)
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<ActorData>() {
        override fun areItemsTheSame(oldItem: ActorData, newItem: ActorData): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: ActorData, newItem: ActorData): Boolean {
            return oldItem == newItem
        }
    }
}
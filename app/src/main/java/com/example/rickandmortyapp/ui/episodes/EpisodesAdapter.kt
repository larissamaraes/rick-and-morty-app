package com.example.rickandmortyapp.ui.episodes

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.model.Episode
import com.example.rickandmortyapp.model.Location

class EpisodesAdapter : PagedListAdapter<Episode, RecyclerView.ViewHolder>(OBJECT_DIFF) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return EpisodeViewHolder.inflate(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as EpisodeViewHolder).bindEpisode(getItem(position))
    }

    companion object {
        private val OBJECT_DIFF = object : DiffUtil.ItemCallback<Episode>() {
            override fun areContentsTheSame(oldItem: Episode, newItem: Episode): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: Episode, newItem: Episode): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}

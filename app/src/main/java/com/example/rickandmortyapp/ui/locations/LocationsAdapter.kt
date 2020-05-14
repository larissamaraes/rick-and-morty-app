package com.example.rickandmortyapp.ui.locations

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.model.Location

class LocationsAdapter : PagedListAdapter<Location, RecyclerView.ViewHolder>(OBJECT_DIFF) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return LocationViewHolder.inflate(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? LocationViewHolder)?.bindLocation(getItem(position))
    }

    companion object {
        private val OBJECT_DIFF = object : DiffUtil.ItemCallback<Location>() {
            override fun areContentsTheSame(oldItem: Location, newItem: Location): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: Location, newItem: Location): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}

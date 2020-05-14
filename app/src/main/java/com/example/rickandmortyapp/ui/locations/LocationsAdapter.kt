package com.example.rickandmortyapp.ui.locations

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.model.Location
import com.example.rickandmortyapp.ui.loading.LoadingViewHolder

class LocationsAdapter : PagedListAdapter<Location, RecyclerView.ViewHolder>(OBJECT_DIFF) {

    private var hasMorePages: Boolean = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            LOCATION_VIEW_TYPE -> LocationViewHolder.inflate(parent)
            LOADING_VIEW_TYPE -> LoadingViewHolder.inflate(parent)
            else -> throw RuntimeException("Location view type not found!")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == LOCATION_VIEW_TYPE) {
            (holder as? LocationViewHolder)?.bindLocation(getItem(position))
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (hasMorePages && position == itemCount - 1) LOADING_VIEW_TYPE else LOCATION_VIEW_TYPE
    }

    override fun getItemCount(): Int = super.getItemCount() + if (hasMorePages) 1 else 0

    fun setHasMorePages(hasMorePages: Boolean) {
        this.hasMorePages = hasMorePages
        if (!hasMorePages) notifyDataSetChanged()
    }

    companion object {
        private const val LOCATION_VIEW_TYPE = 1
        private const val LOADING_VIEW_TYPE = 2

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

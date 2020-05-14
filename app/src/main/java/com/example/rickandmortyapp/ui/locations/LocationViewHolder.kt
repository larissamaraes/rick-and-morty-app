package com.example.rickandmortyapp.ui.locations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.databinding.ItemListLocationBinding
import com.example.rickandmortyapp.model.Location

class LocationViewHolder(
    private val binding: ItemListLocationBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bindLocation(location: Location?) {
        location?.let {
            with(binding) {
                locationName.text = it.name
                locationType.text = root.context.getString(R.string.location_type, it.type.capitalize())
            }
        }
    }

    companion object {
        fun inflate(viewGroup: ViewGroup): LocationViewHolder {
            return LocationViewHolder(
                ItemListLocationBinding.inflate(
                    LayoutInflater.from(viewGroup.context),
                    viewGroup,
                    false
                )
            )
        }
    }
}

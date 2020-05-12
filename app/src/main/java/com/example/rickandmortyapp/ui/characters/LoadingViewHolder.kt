package com.example.rickandmortyapp.ui.characters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.databinding.ItemListLoadingPlaceholderBinding

class LoadingViewHolder(
    private val binding: ItemListLoadingPlaceholderBinding
) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun inflate(viewGroup: ViewGroup): LoadingViewHolder {
            return LoadingViewHolder(
                ItemListLoadingPlaceholderBinding.inflate(
                    LayoutInflater.from(viewGroup.context),
                    viewGroup,
                    false
                )
            )
        }
    }
}

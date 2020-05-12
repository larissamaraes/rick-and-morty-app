package com.example.rickandmortyapp.ui.characters

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.model.Character

class CharactersAdapter : PagedListAdapter<Character, RecyclerView.ViewHolder>(OBJECT_DIFF) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            CHARACTER_VIEW_TYPE -> CharactersViewHolder.inflate(parent)
            PROGRESS_VIEW_TYPE -> LoadingViewHolder.inflate(parent)
            else -> throw RuntimeException("view type not found!")
        }
    }

    override fun getItemCount(): Int = super.getItemCount() + if (super.getItemCount() > 0) 1 else 0

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == CHARACTER_VIEW_TYPE) (holder as? CharactersViewHolder)?.bindCharacter(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return if (position != itemCount - 1) CHARACTER_VIEW_TYPE else PROGRESS_VIEW_TYPE
    }

    companion object {
        private const val PROGRESS_VIEW_TYPE = 1
        private const val CHARACTER_VIEW_TYPE = 2

        private val OBJECT_DIFF = object : DiffUtil.ItemCallback<Character>() {
            override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}

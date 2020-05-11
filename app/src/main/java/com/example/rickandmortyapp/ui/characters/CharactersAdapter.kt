package com.example.rickandmortyapp.ui.characters

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.rickandmortyapp.model.Character

class CharactersAdapter : PagedListAdapter<Character, CharactersViewHolder>(OBJECT_DIFF) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        return CharactersViewHolder.inflate(parent)
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.bindCharacter(getItem(position))
    }

    companion object {
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

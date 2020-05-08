package com.example.rickandmortyapp.ui.characters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.model.Character

class CharactersAdapter : RecyclerView.Adapter<CharactersViewHolder>() {

    private var characters: List<Character> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        return CharactersViewHolder.inflate(parent)
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.bindCharacter(characters[position])
    }

    fun setCharacters(characters: List<Character>) {
        this.characters = characters
        notifyDataSetChanged()
    }
}

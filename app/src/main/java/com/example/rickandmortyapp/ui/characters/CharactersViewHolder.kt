package com.example.rickandmortyapp.ui.characters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.databinding.ItemListCharacterBinding
import com.example.rickandmortyapp.model.Character

class CharactersViewHolder(
    private val binding: ItemListCharacterBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bindCharacter(character: Character) {
        with(binding) {
            characterName.text = character.name
            characterStatus.text = root.context.getString(
                R.string.character_status,
                character.status.capitalize()
            )
            Glide.with(this.root)
                .load(character.image)
                .transform(RoundedCorners(8))
                .into(characterAvatar)
        }
    }

    companion object {
        fun inflate(viewGroup: ViewGroup): CharactersViewHolder {
            return CharactersViewHolder(
                ItemListCharacterBinding.inflate(
                    LayoutInflater.from(viewGroup.context),
                    viewGroup,
                    false
                )
            )
        }
    }
}

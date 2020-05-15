package com.example.rickandmortyapp.ui.episodes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.databinding.ItemListEpisodeBinding
import com.example.rickandmortyapp.model.Episode

class EpisodeViewHolder(
    private val binding: ItemListEpisodeBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bindEpisode(episode: Episode?) {
        episode?.let {
            with(binding) {
                episodeText.text = root.context.getString(
                    R.string.episode_text,
                    it.name.capitalize(),
                    it.episode.capitalize()
                )
                episodeAirDate.text = it.airDate
            }
        }
    }

    companion object {
        fun inflate(viewGroup: ViewGroup): EpisodeViewHolder {
            return EpisodeViewHolder(
                ItemListEpisodeBinding.inflate(
                    LayoutInflater.from(viewGroup.context),
                    viewGroup,
                    false
                )
            )
        }
    }
}

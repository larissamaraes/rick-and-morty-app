package com.example.rickandmortyapp.ui.episodes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.rickandmortyapp.model.Episode
import com.example.rickandmortyapp.remote.NetworkUtils
import com.example.rickandmortyapp.remote.paging.EpisodeDataSourceFactory

class EpisodesViewModel : ViewModel() {

    private val sourceFactory: EpisodeDataSourceFactory by lazy {
        EpisodeDataSourceFactory(viewModelScope, NetworkUtils.getNetworkService())
    }

    private var episodes: LiveData<PagedList<Episode>>

    init {
        episodes = LivePagedListBuilder(sourceFactory, NetworkUtils.getPagedConfig()).build()
    }

    fun getEpisodes() = episodes
}

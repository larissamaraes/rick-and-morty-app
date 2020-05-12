package com.example.rickandmortyapp.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.rickandmortyapp.model.Character
import com.example.rickandmortyapp.remote.NetworkUtils
import com.example.rickandmortyapp.remote.paging.CharacterDataSourceFactory

class CharactersViewModel : ViewModel() {

    private val sourceFactory: CharacterDataSourceFactory by lazy {
        CharacterDataSourceFactory(viewModelScope, NetworkUtils.getNetworkService())
    }

    private var characters: LiveData<PagedList<Character>>

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(NetworkUtils.PAGE_SIZE)
            .setInitialLoadSizeHint(NetworkUtils.PAGE_SIZE * 2)
            .setEnablePlaceholders(false)
            .build()
        characters = LivePagedListBuilder(sourceFactory, config).build()
    }

    fun getCharacters() = characters
}

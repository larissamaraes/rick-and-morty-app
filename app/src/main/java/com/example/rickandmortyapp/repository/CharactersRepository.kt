package com.example.rickandmortyapp.repository

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.rickandmortyapp.RickAndMortyApplication
import com.example.rickandmortyapp.model.Character
import com.example.rickandmortyapp.remote.NetworkUtils
import com.example.rickandmortyapp.remote.api.ApiService
import com.example.rickandmortyapp.remote.paging.CharacterBoundaryCallback

class CharactersRepository(
    private val apiService: ApiService
) {

    fun getCharacters(): LiveData<PagedList<Character>>? {
        val dataSource = RickAndMortyApplication.database?.characterDao()?.getCharacters()
        val boundaryCallback = CharacterBoundaryCallback(apiService)
        return dataSource?.let {
            LivePagedListBuilder(it, NetworkUtils.getPagedConfig())
                .setBoundaryCallback(boundaryCallback)
                .build()
        }
    }
}

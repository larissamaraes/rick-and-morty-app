package com.example.rickandmortyapp.remote.paging

import androidx.paging.DataSource
import com.example.rickandmortyapp.model.Character
import com.example.rickandmortyapp.remote.ApiService
import kotlinx.coroutines.CoroutineScope

class CharacterDataSourceFactory(
    private val coroutineScope: CoroutineScope,
    private val apiService: ApiService,
    private val hasMorePagesCallback: (Boolean) -> Unit
) : DataSource.Factory<Int, Character>() {
    override fun create(): DataSource<Int, Character> = CharactersDataSource(
        coroutineScope,
        apiService,
        hasMorePagesCallback
    )
}

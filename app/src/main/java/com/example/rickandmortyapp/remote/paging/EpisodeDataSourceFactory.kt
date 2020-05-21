package com.example.rickandmortyapp.remote.paging

import androidx.paging.DataSource
import com.example.rickandmortyapp.model.Episode
import com.example.rickandmortyapp.remote.api.ApiService
import kotlinx.coroutines.CoroutineScope

class EpisodeDataSourceFactory (
    private val coroutineScope: CoroutineScope,
    private val apiService: ApiService
) : DataSource.Factory<Int, Episode>() {
    override fun create(): DataSource<Int, Episode> {
        return EpisodeDataSource(coroutineScope, apiService)
    }
}

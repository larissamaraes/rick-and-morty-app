package com.example.rickandmortyapp.remote.paging

import androidx.paging.DataSource
import com.example.rickandmortyapp.model.Location
import com.example.rickandmortyapp.remote.ApiService
import kotlinx.coroutines.CoroutineScope

class LocationsDataSourceFactory(
    private val coroutineScope: CoroutineScope,
    private val apiService: ApiService,
    private val hasMorePagesCallback: (Boolean) -> Unit
) : DataSource.Factory<Int, Location>() {
    override fun create(): DataSource<Int, Location> = LocationsDataSource(
        coroutineScope,
        apiService,
        hasMorePagesCallback
    )
}

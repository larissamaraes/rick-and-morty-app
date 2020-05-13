package com.example.rickandmortyapp.ui.locations

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.rickandmortyapp.model.Location
import com.example.rickandmortyapp.remote.NetworkUtils
import com.example.rickandmortyapp.remote.paging.LocationsDataSourceFactory

class LocationsViewModel : ViewModel() {

    private val sourceFactory: LocationsDataSourceFactory by lazy {
        LocationsDataSourceFactory(viewModelScope, NetworkUtils.getNetworkService()) {  }
    }

    private var locations: LiveData<PagedList<Location>>

    init {
        locations = LivePagedListBuilder(sourceFactory, NetworkUtils.getPagedConfig()).build()
    }

    fun getLocations() = locations
}

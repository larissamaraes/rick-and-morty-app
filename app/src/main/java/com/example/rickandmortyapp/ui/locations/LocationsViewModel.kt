package com.example.rickandmortyapp.ui.locations

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.rickandmortyapp.model.Location
import com.example.rickandmortyapp.remote.NetworkUtils
import com.example.rickandmortyapp.remote.paging.LocationsDataSourceFactory

class LocationsViewModel : ViewModel() {

    val hasMorePages: LiveData<Boolean> get() = _hasMorePages

    private val _hasMorePages: MutableLiveData<Boolean> = MutableLiveData(false)

    private val sourceFactory: LocationsDataSourceFactory by lazy {
        LocationsDataSourceFactory(viewModelScope, NetworkUtils.getNetworkService(), ::handleHasMorePages)
    }

    private var locations: LiveData<PagedList<Location>>

    init {
        locations = LivePagedListBuilder(sourceFactory, NetworkUtils.getPagedConfig()).build()
    }

    fun getLocations() = locations

    private fun handleHasMorePages(hasMorePages: Boolean) {
        _hasMorePages.value = hasMorePages
    }
}

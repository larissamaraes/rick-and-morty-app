package com.example.rickandmortyapp.remote.paging

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.example.rickandmortyapp.model.Location
import com.example.rickandmortyapp.remote.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class LocationsDataSource(
    private val coroutineScope: CoroutineScope,
    private val apiService: ApiService,
    private val hasMorePagesCallback: (Boolean) -> Unit
) : PageKeyedDataSource<Int, Location>() {
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Location>) {
        createCoroutine(0, 1, callback, null)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Location>) {
        createCoroutine(params.key, params.key + 1, null, callback)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Location>) {
        createCoroutine(params.key, params.key - 1, null, callback)
    }

    override fun invalidate() {
        super.invalidate()
        coroutineScope.cancel()
    }

    private fun createCoroutine(
        requestedPage: Int,
        adjacentPage: Int,
        initialCallback: LoadInitialCallback<Int, Location>?,
        callback: LoadCallback<Int, Location>?
    ) {
        coroutineScope.launch {
            try {
                val result = apiService.getLocations(requestedPage)
                initialCallback?.onResult(result.locations, null, adjacentPage)
                callback?.onResult(result.locations, adjacentPage)
                hasMorePagesCallback.invoke(requestedPage != result.info.pages)
            } catch (e: Exception) {
                Log.d("[LOCATION] ERROR PAGE: ", requestedPage.toString())
            }
        }
    }
}

package com.example.rickandmortyapp.remote.paging

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.example.rickandmortyapp.model.Episode
import com.example.rickandmortyapp.remote.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class EpisodeDataSource(
    private val coroutineScope: CoroutineScope,
    private val apiService: ApiService
) : PageKeyedDataSource<Int, Episode>() {
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Episode>) {
        createCoroutine(0, 1, callback, null)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Episode>) {
        createCoroutine(params.key, params.key + 1, null, callback)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Episode>) {
        createCoroutine(params.key, params.key - 1, null, callback)
    }

    override fun invalidate() {
        super.invalidate()
        coroutineScope.cancel()
    }

    private fun createCoroutine(
        requestedPage: Int,
        adjacentPage: Int,
        initialCallback: LoadInitialCallback<Int, Episode>?,
        callback: LoadCallback<Int, Episode>?
    ) {
        coroutineScope.launch {
            try {
                val result = apiService.getEpisodes(requestedPage)
                initialCallback?.onResult(result.locations, null, adjacentPage)
                callback?.onResult(result.locations, adjacentPage)
            } catch (e: Exception) {
                Log.d("[EPISODE] ERROR PAGE: ", requestedPage.toString())
            }
        }
    }
}

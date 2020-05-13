package com.example.rickandmortyapp.remote.paging

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.example.rickandmortyapp.model.Character
import com.example.rickandmortyapp.remote.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class CharactersDataSource(
    private val coroutineScope: CoroutineScope,
    private val apiService: ApiService,
    private val hasMorePagesCallback: (Boolean) -> Unit
) : PageKeyedDataSource<Int, Character>() {
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Character>) {
        createCoroutine(0, 1, callback, null)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Character>) {
        createCoroutine(params.key, params.key + 1, null, callback)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Character>) {
        createCoroutine(params.key, params.key - 1, null, callback)
    }

    override fun invalidate() {
        super.invalidate()
        coroutineScope.cancel()
    }

    private fun createCoroutine(
        requestedPage: Int,
        adjacentPage: Int,
        initialCallback: LoadInitialCallback<Int, Character>?,
        callback: LoadCallback<Int, Character>?
    ) {
        coroutineScope.launch {
            try {
                val result = apiService.getCharacters(requestedPage)
                initialCallback?.onResult(result.characters, null, adjacentPage)
                callback?.onResult(result.characters, adjacentPage)
                hasMorePagesCallback.invoke(requestedPage != result.info.pages)
            } catch (e: Exception) {
                Log.d("[CHARACTER] ERROR PAGE:", requestedPage.toString())
            }
        }
    }
}

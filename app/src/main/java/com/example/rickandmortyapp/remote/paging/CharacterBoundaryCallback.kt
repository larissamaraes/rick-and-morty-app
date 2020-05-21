package com.example.rickandmortyapp.remote.paging

import android.util.Log
import androidx.paging.PagedList
import com.example.rickandmortyapp.RickAndMortyApplication
import com.example.rickandmortyapp.dao.CharacterDao
import com.example.rickandmortyapp.model.Character
import com.example.rickandmortyapp.remote.api.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterBoundaryCallback(
    private val apiService: ApiService
) : PagedList.BoundaryCallback<Character>() {

    private val characterDao: CharacterDao? by lazy {
        RickAndMortyApplication.database?.characterDao()
    }
    private var lastRequestedPage = 1

    override fun onZeroItemsLoaded() {
        requestAndSaveData()
    }

    override fun onItemAtEndLoaded(itemAtEnd: Character) {
        requestAndSaveData()
    }

    private fun requestAndSaveData() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val result = apiService.getCharacters(lastRequestedPage)
                characterDao?.insertCharacters(result.characters)
                lastRequestedPage++
            } catch (e: Exception) {
                Log.d("[CHARACTER] ERROR PAGE:", lastRequestedPage.toString())
            }
        }
    }
}

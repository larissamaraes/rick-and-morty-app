package com.example.rickandmortyapp.repository

import com.example.rickandmortyapp.remote.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterRepository(
    private val apiService: ApiService
) {

    suspend fun getCharacters() {
        try {
            val charactersResponse = withContext(Dispatchers.IO) {
                apiService.getCharacters()
            }
            charactersResponse.characters
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}

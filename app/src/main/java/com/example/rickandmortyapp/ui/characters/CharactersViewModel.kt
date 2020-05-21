package com.example.rickandmortyapp.ui.characters

import androidx.lifecycle.ViewModel
import com.example.rickandmortyapp.remote.NetworkUtils
import com.example.rickandmortyapp.repository.CharactersRepository

class CharactersViewModel : ViewModel() {

    private val charactersRepository: CharactersRepository by lazy {
        CharactersRepository(NetworkUtils.getNetworkService())
    }

    fun getCharacters() = charactersRepository.getCharacters()
}

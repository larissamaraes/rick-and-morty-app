package com.example.rickandmortyapp.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.rickandmortyapp.model.Character
import com.example.rickandmortyapp.remote.NetworkUtils
import com.example.rickandmortyapp.repository.CharactersRepository

class CharactersViewModel : ViewModel() {

    val finishPaging: LiveData<Boolean> get() = _finishPaging
    private val _finishPaging: MutableLiveData<Boolean> = MutableLiveData()

    private val charactersRepository: CharactersRepository by lazy {
        CharactersRepository(NetworkUtils.getNetworkService())
    }

    fun getCharacters() = charactersRepository.getCharacters()
}

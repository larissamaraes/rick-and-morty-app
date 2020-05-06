package com.example.rickandmortyapp.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapp.model.Character
import com.example.rickandmortyapp.remote.NetworkUtils
import com.example.rickandmortyapp.repository.CharacterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharactersViewModel : ViewModel() {

    val characters: LiveData<List<Character>> get() = _characters
    private val _characters: MutableLiveData<List<Character>> = MutableLiveData()

    private val characterRepository: CharacterRepository = CharacterRepository(NetworkUtils.getNetworkService())

    fun getCharacters() {
        val scope = CoroutineScope(Dispatchers.Main)
        scope.launch {
            _characters.value = characterRepository.getCharacters()
        }
    }
}

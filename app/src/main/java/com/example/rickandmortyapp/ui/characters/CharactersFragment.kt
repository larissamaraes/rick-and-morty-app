package com.example.rickandmortyapp.ui.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rickandmortyapp.databinding.FragmentCharactersBinding
import com.example.rickandmortyapp.remote.NetworkUtils
import com.example.rickandmortyapp.repository.CharacterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharactersFragment : Fragment() {

    private lateinit var binding: FragmentCharactersBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCharactersBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        val scope = CoroutineScope(Dispatchers.Main)
        val characterRepository = CharacterRepository(NetworkUtils.getNetworkService())
        scope.launch {
            characterRepository.getCharacters()
        }
    }

    companion object {
        fun newInstance(): CharactersFragment = CharactersFragment()
    }
}

package com.example.rickandmortyapp.ui.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.rickandmortyapp.databinding.FragmentCharactersBinding
import com.example.rickandmortyapp.model.Character

class CharactersFragment : Fragment() {

    private lateinit var binding: FragmentCharactersBinding
    private val viewModel: CharactersViewModel = CharactersViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCharactersBinding.inflate(layoutInflater)
        subscribeUi()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getCharacters()
    }

    private fun subscribeUi() {
        viewModel.characters.observe(viewLifecycleOwner, Observer { onCharacters(it) })
    }

    private fun onCharacters(characters: List<Character>?) {
        characters
        // TODO RECEIVE CHARACTERS LIST
    }

    companion object {
        fun newInstance(): CharactersFragment = CharactersFragment()
    }
}

package com.example.rickandmortyapp.ui.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.databinding.FragmentCharactersBinding
import com.example.rickandmortyapp.model.Character

class CharactersFragment : Fragment() {

    private lateinit var binding: FragmentCharactersBinding
    private val viewModel: CharactersViewModel = CharactersViewModel()
    private val charactersAdapter: CharactersAdapter by lazy { CharactersAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCharactersBinding.inflate(layoutInflater)
        subscribeUi()
        setupRecyclerView()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getCharacters()
    }

    private fun subscribeUi() {
        viewModel.characters.observe(viewLifecycleOwner, Observer { onCharacters(it) })
    }

    private fun setupRecyclerView() {
        with(binding.charactersList) {
            layoutManager = LinearLayoutManager(context)
            adapter = charactersAdapter
        }
    }

    private fun onCharacters(characters: List<Character>?) {
        characters?.let {
            charactersAdapter.setCharacters(it)
        }
    }

    companion object {
        fun newInstance(): CharactersFragment = CharactersFragment()
    }
}

package com.example.rickandmortyapp.ui.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapp.databinding.FragmentCharactersBinding
import com.example.rickandmortyapp.model.Character

class CharactersFragment : Fragment() {

    private lateinit var binding: FragmentCharactersBinding
    private lateinit var viewModel: CharactersViewModel
    private val charactersAdapter: CharactersAdapter by lazy { CharactersAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCharactersBinding.inflate(layoutInflater)
        viewModel = ViewModelProviders.of(this).get(CharactersViewModel::class.java)
        subscribeUi()
        setupRecyclerView()
        return binding.root
    }

    private fun subscribeUi() {
        viewModel.finishPaging.observe(viewLifecycleOwner, Observer { onFinishPaging(it) })
        viewModel.getCharacters()?.observe(viewLifecycleOwner, Observer { onCharacters(it) })
    }

    private fun setupRecyclerView() {
        with(binding.charactersList) {
            layoutManager = LinearLayoutManager(context)
            adapter = charactersAdapter
        }
    }

    private fun onCharacters(characters: PagedList<Character>?) {
        charactersAdapter.submitList(characters)
    }

    private fun onFinishPaging(shouldFinish: Boolean?) {
        shouldFinish?.let {
            charactersAdapter.onPagingFinished()
        }
    }

    companion object {
        fun newInstance(): CharactersFragment = CharactersFragment()
    }
}

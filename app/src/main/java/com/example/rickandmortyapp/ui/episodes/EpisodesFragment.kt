package com.example.rickandmortyapp.ui.episodes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapp.databinding.FragmentEpisodesBinding
import com.example.rickandmortyapp.model.Episode

class EpisodesFragment : Fragment() {

    private val episodesAdapter: EpisodesAdapter by lazy { EpisodesAdapter() }

    private lateinit var binding: FragmentEpisodesBinding
    private lateinit var viewModel: EpisodesViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentEpisodesBinding.inflate(layoutInflater)
        viewModel = ViewModelProviders.of(this).get(EpisodesViewModel::class.java)
        subscribeUi()
        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView() {
        with(binding.episodesList) {
            layoutManager = LinearLayoutManager(context)
            adapter = episodesAdapter
        }
    }

    private fun subscribeUi() {
        viewModel.getEpisodes().observe(viewLifecycleOwner, Observer { onEpisodes(it) })
    }

    private fun onEpisodes(episodes: PagedList<Episode>?) {
        episodesAdapter.submitList(episodes)
    }

    companion object {
        fun newInstance(): EpisodesFragment = EpisodesFragment()
    }
}

package com.example.rickandmortyapp.ui.episodes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rickandmortyapp.databinding.FragmentEpisodesBinding

class EpisodesFragment : Fragment() {

    private lateinit var binding: FragmentEpisodesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentEpisodesBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
        fun newInstance(): EpisodesFragment = EpisodesFragment()
    }
}

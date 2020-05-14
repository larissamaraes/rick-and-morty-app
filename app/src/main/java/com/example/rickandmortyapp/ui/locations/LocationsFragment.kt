package com.example.rickandmortyapp.ui.locations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapp.databinding.FragmentLocationsBinding
import com.example.rickandmortyapp.model.Location

class LocationsFragment : Fragment() {

    private lateinit var binding: FragmentLocationsBinding
    private lateinit var viewModel: LocationsViewModel

    private val locationsAdapter: LocationsAdapter by lazy { LocationsAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLocationsBinding.inflate(layoutInflater)
        viewModel = ViewModelProviders.of(this).get(LocationsViewModel::class.java)
        subscribeUi()
        setupRecyclerView()
        return binding.root
    }

    private fun subscribeUi() {
        viewModel.getLocations().observe(viewLifecycleOwner, Observer { onLocations(it) })
    }

    private fun setupRecyclerView() {
        with(binding.locationsList) {
            layoutManager = LinearLayoutManager(context)
            adapter = locationsAdapter
        }
    }

    private fun onLocations(locations: PagedList<Location>?) {
        locationsAdapter.submitList(locations)
    }

    companion object {
        fun newInstance(): LocationsFragment = LocationsFragment()
    }
}

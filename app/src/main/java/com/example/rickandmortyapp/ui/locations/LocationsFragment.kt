package com.example.rickandmortyapp.ui.locations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import com.example.rickandmortyapp.databinding.FragmentLocationsBinding
import com.example.rickandmortyapp.model.Location

class LocationsFragment : Fragment() {

    private lateinit var binding: FragmentLocationsBinding
    private lateinit var viewModel: LocationsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLocationsBinding.inflate(layoutInflater)
        viewModel = ViewModelProviders.of(this).get(LocationsViewModel::class.java)
        subscribeUi()
        return binding.root
    }

    private fun subscribeUi() {
        viewModel.getLocations().observe(viewLifecycleOwner, Observer { onLocations(it) })
    }

    private fun onLocations(locations: PagedList<Location>?) {
        // submit list to adapter
    }

    companion object {
        fun newInstance(): LocationsFragment = LocationsFragment()
    }
}

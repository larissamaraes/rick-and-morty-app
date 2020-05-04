package com.example.rickandmortyapp.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.characters.CharactersFragment
import com.example.rickandmortyapp.episodes.EpisodesFragment
import com.example.rickandmortyapp.locations.LocationsFragment
import java.lang.RuntimeException

private val TAB_TITLES = arrayOf(
    R.string.tab_text_characters,
    R.string.tab_text_locations,
    R.string.tab_text_episodes
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> CharactersFragment.newInstance()
            1 -> LocationsFragment.newInstance()
            2 -> EpisodesFragment.newInstance()
            else -> throw RuntimeException("Fragment tab item not found!")
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return TAB_TITLES.size
    }
}

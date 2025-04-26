package com.medvedev.courses.presentation

import androidx.fragment.app.Fragment
import com.medvedev.courses.R

class FavoritesFragment : Fragment(R.layout.fragment_favorites) {

    companion object {
        @JvmStatic
        fun getInstance() = FavoritesFragment()
    }
}
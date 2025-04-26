package com.medvedev.courses.presentation

import androidx.fragment.app.Fragment
import com.medvedev.courses.R

class MainFragment : Fragment(R.layout.fragment_main) {

    companion object {
        @JvmStatic
        fun getInstance() = MainFragment()
    }
}
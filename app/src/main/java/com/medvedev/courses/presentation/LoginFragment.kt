package com.medvedev.courses.presentation

import androidx.fragment.app.Fragment
import com.medvedev.courses.R

class LoginFragment : Fragment(R.layout.fragment_login) {

    companion object {
        @JvmStatic
        fun getInstance() = LoginFragment()
    }
}
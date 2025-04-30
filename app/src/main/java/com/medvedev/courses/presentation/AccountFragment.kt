package com.medvedev.courses.presentation

import androidx.fragment.app.Fragment
import com.medvedev.courses.R

class AccountFragment : Fragment(R.layout.fragment_account) {

    companion object {
        @JvmStatic
        fun getInstance() = AccountFragment()
    }
}
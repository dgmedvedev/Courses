package com.medvedev.courses.presentation

import androidx.fragment.app.Fragment
import com.medvedev.courses.R

class OnboardingFragment : Fragment(R.layout.fragment_onboarding) {

    companion object {
        @JvmStatic
        fun getInstance() = OnboardingFragment()
    }
}
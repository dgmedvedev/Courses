package com.medvedev.courses.presentation

import android.os.Bundle
import android.view.View
import android.widget.HorizontalScrollView
import androidx.fragment.app.Fragment
import com.medvedev.courses.R
import com.medvedev.courses.databinding.FragmentOnboardingBinding
import dev.androidbroadcast.vbpd.viewBinding

class OnboardingFragment : Fragment(R.layout.fragment_onboarding) {

    private val binding by viewBinding(FragmentOnboardingBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        horizontalScrollToCenter(binding.horizontalScrollView)
        setListener()
    }

    private fun horizontalScrollToCenter(horizontalScrollView: HorizontalScrollView) {
        horizontalScrollView.post {
            val scrollX =
                (horizontalScrollView.getChildAt(0).width - horizontalScrollView.width) / 2
            val scrollY = 0
            horizontalScrollView.scrollTo(scrollX, scrollY)
        }
    }

    private fun setListener() {
        binding.btnContinue.setOnClickListener {
            launchFragment(LoginFragment.getInstance())
        }
    }

    private fun launchFragment(fragment: Fragment) {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.container_main, fragment)
            .commit()
    }
}
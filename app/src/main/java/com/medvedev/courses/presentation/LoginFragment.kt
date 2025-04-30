package com.medvedev.courses.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.medvedev.courses.R
import com.medvedev.courses.databinding.FragmentLoginBinding
import dev.androidbroadcast.vbpd.viewBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding by viewBinding(FragmentLoginBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
    }

    private fun setListener() {
        binding.btnLogin.setOnClickListener {
            launchFragment(MainFragment.getInstance())
        }
    }

    private fun launchFragment(fragment: Fragment) {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.container_main, fragment)
            .commit()
    }

    companion object {
        @JvmStatic
        fun getInstance() = LoginFragment()
    }
}
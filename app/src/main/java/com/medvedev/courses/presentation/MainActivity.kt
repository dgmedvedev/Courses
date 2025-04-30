package com.medvedev.courses.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.medvedev.courses.R
import com.medvedev.courses.databinding.ActivityMainBinding
import dev.androidbroadcast.vbpd.viewBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.activityMain) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setListener()
    }

    private fun setListener() {
        binding.bottomNavigation.setOnNavItemClickListener { index ->
            when (index) {
                0 -> launchFragment(MainFragment.getInstance())
                1 -> launchFragment(FavoritesFragment.getInstance())
                2 -> launchFragment(AccountFragment.getInstance())
                else -> return@setOnNavItemClickListener
            }
        }
    }

    private fun launchFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container_main, fragment)
            .commit()
    }
}
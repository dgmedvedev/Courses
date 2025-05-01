package com.medvedev.courses.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.medvedev.courses.R
import com.medvedev.courses.data.network.ApiFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainFragment : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        testNetwork()
    }

    private fun testNetwork() {
        val apiService = ApiFactory.apiService

        val coursesDeferred = lifecycleScope.async {
            withContext(Dispatchers.IO) {
                apiService.getCourses()
            }
        }
        lifecycleScope.launch {
            val courses = coursesDeferred.await().courses
            Log.d(TAG, "$courses")
        }
    }

    companion object {
        private const val TAG = "TEST_NETWORK"

        @JvmStatic
        fun getInstance() = MainFragment()
    }
}
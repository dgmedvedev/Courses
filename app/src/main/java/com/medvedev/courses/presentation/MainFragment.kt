package com.medvedev.courses.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.medvedev.courses.R
import com.medvedev.courses.data.network.ApiFactory
import com.medvedev.courses.databinding.FragmentMainBinding
import com.medvedev.courses.domain.model.Course
import com.medvedev.courses.presentation.adapter.CourseAdapter
import dev.androidbroadcast.vbpd.viewBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewBinding(FragmentMainBinding::bind)

    private val courseAdapter by lazy {
        CourseAdapter(onCourseItemClickListener())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        testNetwork()
        testCourseAdapter()
    }

    private fun onCourseItemClickListener(): (Course) -> Unit = { course ->
        Toast.makeText(requireContext(), "${course.id}", Toast.LENGTH_SHORT).show()
    }

    private fun setAdapter() {
        binding.rvCourses.adapter = courseAdapter
    }

    private fun testCourseAdapter() {
        val courses = listOf(
            Course(1, "java", "Вакансии", "111", "4.1", "2024-05-22", false, "2024-02-11"),
            Course(2, "kotlin", "Вакансии", "222", "4.5", "2024-03-30", true, "2024-01-21"),
            Course(3, "android", "Вакансии", "333", "4.7", "2024-01-18", false, "2024-04-17"),
            Course(4, "python", "Вакансии", "444", "4.2", "2024-07-02", true, "2024-08-22"),
        )
        courseAdapter.submitList(courses)
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
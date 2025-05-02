package com.medvedev.courses.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.medvedev.courses.R
import com.medvedev.courses.databinding.CourseItemBinding
import com.medvedev.courses.domain.model.Course
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

class CourseAdapter(private val onCourseItemClickListener: ((Course) -> Unit)?) :
    ListAdapter<Course, CourseAdapter.CourseHolder>(CourseDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseHolder {
        val binding = CourseItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CourseHolder(binding)
    }

    override fun onBindViewHolder(holder: CourseHolder, position: Int) {
        val course: Course = getItem(position)
        holder.bind(course = course)
    }

    inner class CourseHolder(private val binding: CourseItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var courseItem: Course

        fun bind(course: Course) {
            courseItem = course
            binding.apply {
                val randomIndex = (Math.random() * 3).toInt()
                ivCourse.setImageResource(courseImageResources[randomIndex])
                tvRate.text = courseItem.rate
                tvStartDate.text = convertDate(courseItem.startDate)
                ivIconFavorites.setImageResource(
                    if (courseItem.hasLike) R.drawable.icon_bookmark_fill else R.drawable.icon_bookmark
                )
                tvTitle.text = courseItem.title
                tvText.text = courseItem.text
                tvText.maxLines = 2
                tvText.ellipsize = android.text.TextUtils.TruncateAt.END
                tvPrice.text = courseItem.price
                root.setOnClickListener {
                    onCourseItemClickListener?.invoke(courseItem)
                }
            }
        }
    }

    private class CourseDiffCallback : DiffUtil.ItemCallback<Course>() {
        override fun areItemsTheSame(oldItem: Course, newItem: Course): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Course, newItem: Course): Boolean {
            return oldItem == newItem
        }
    }

    private fun convertDate(input: String): String {
        val inputFormatter = DateTimeFormatter.ofPattern(PATTERN_INPUT_DATE)
        val date = LocalDate.parse(input, inputFormatter)
        val outputFormatter = DateTimeFormatter.ofPattern(PATTERN_OUTPUT_DATE, Locale(LANGUAGE))
        val convertDate = date.format(outputFormatter)
        val firstCharMonth = convertDate.substring(START_INDEX, END_INDEX).uppercase()
        return convertDate.replaceRange(START_INDEX, END_INDEX, firstCharMonth)
    }

    companion object {
        private const val LANGUAGE = "RU"
        private const val PATTERN_INPUT_DATE = "yyyy-MM-dd"
        private const val PATTERN_OUTPUT_DATE = "dd MMMM yyyy"
        private const val START_INDEX = 3
        private const val END_INDEX = 4

        private val courseImageResources = listOf<Int>(
            R.drawable.course_image_0,
            R.drawable.course_image_1,
            R.drawable.course_image_2
        )
    }
}
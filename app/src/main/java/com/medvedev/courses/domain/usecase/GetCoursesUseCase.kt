package com.medvedev.courses.domain.usecase

import com.medvedev.courses.domain.model.Course
import com.medvedev.courses.domain.repository.CoursesRepository

class GetCoursesUseCase(private val repository: CoursesRepository) {
    suspend operator fun invoke(): List<Course> = repository.getCourses()
}
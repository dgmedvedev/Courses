package com.medvedev.courses.domain.usecase

import com.medvedev.courses.domain.model.Course
import com.medvedev.courses.domain.repository.CoursesRepository

class GetCoursesFavoritesUseCase(private val repository: CoursesRepository) {
    suspend operator fun invoke(): List<Course> = repository.getCoursesFavorites()
}
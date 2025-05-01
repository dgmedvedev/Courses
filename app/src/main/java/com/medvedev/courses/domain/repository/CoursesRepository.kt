package com.medvedev.courses.domain.repository

import com.medvedev.courses.domain.model.Course

interface CoursesRepository {
    suspend fun getCourses(): List<Course>
    suspend fun getCoursesFavorites(): List<Course>
}
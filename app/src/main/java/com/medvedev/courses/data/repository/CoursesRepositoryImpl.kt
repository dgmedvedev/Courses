package com.medvedev.courses.data.repository

import com.medvedev.courses.data.network.ApiService
import com.medvedev.courses.data.toCourseDomainList
import com.medvedev.courses.domain.model.Course
import com.medvedev.courses.domain.repository.CoursesRepository

class CoursesRepositoryImpl(private val apiService: ApiService) : CoursesRepository {
    override suspend fun getCourses(): List<Course> =
        apiService.getCourses().courses?.toCourseDomainList() ?: listOf()

    override suspend fun getCoursesFavorites(): List<Course> =
        getCourses().filter { course -> course.hasLike }
}
package com.medvedev.courses.data.network.model

import com.google.gson.annotations.SerializedName

class CoursesDto {
    @SerializedName("courses")
    val courses: List<CourseDto>? = null
}
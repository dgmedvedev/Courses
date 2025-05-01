package com.medvedev.courses.data.network

import com.medvedev.courses.data.network.model.CoursesDto
import retrofit2.http.GET

interface ApiService {

    @GET(GET_PARAM_VALUE)
    suspend fun getCourses(): CoursesDto

    companion object {
        private const val GET_PARAM_VALUE =
            "u/0/uc?id=15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q&export=download"
    }
}
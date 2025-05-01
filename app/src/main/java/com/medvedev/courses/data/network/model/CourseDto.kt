package com.medvedev.courses.data.network.model

import com.google.gson.annotations.SerializedName

data class CourseDto(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("text")
    val text: String? = null,
    @SerializedName("price")
    val price: String? = null,
    @SerializedName("rate")
    val rate: String? = null,
    @SerializedName("startDate")
    val startDate: String? = null,
    @SerializedName("hasLike")
    val hasLike: Boolean = false,
    @SerializedName("publishDate")
    val publishDate: String? = null
)
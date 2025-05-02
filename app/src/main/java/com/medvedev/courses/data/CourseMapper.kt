package com.medvedev.courses.data

import com.medvedev.courses.data.network.model.CourseDto
import com.medvedev.courses.domain.model.Course

fun Course.toDto() = CourseDto(
    id = id,
    title = title,
    text = text,
    price = price,
    rate = rate,
    startDate = startDate,
    hasLike = hasLike,
    publishDate = publishDate
)

fun CourseDto.toDomain() = Course(
    id = id,
    title = title,
    text = text,
    price = price,
    rate = rate,
    startDate = startDate,
    hasLike = hasLike,
    publishDate = publishDate
)

fun List<CourseDto>.toCourseDomainList() = this.map { it.toDomain() }
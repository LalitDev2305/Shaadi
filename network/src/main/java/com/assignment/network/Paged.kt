package com.assignment.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Paged<T>(

    @SerialName("pageCount")
    val pageCount: Int,

    @SerialName("data")
    val data: List<T>,
)

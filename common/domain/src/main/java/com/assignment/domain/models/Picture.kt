package com.assignment.domain.models
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
)
package com.assignment.data.models
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TimezoneApiModel(
    @SerialName("description")
    val description: String,
    @SerialName("offset")
    val offset: String
)
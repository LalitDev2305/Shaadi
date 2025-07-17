package com.assignment.data.models
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoordinatesApiModel(
    @SerialName("latitude")
    val latitude: String,
    @SerialName("longitude")
    val longitude: String
)
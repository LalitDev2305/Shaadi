package com.assignment.data.models
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StreetApiModel(
    @SerialName("name")
    val name: String,
    @SerialName("number")
    val number: Int
)
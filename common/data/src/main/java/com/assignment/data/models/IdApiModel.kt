package com.assignment.data.models
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IdApiModel(
    @SerialName("name")
    val name: String,
    @SerialName("value")
    val value: String? = ""
)
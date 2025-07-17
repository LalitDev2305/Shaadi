package com.assignment.data.models
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NameApiModel(
    @SerialName("first")
    val first: String,
    @SerialName("last")
    val last: String,
    @SerialName("title")
    val title: String
)
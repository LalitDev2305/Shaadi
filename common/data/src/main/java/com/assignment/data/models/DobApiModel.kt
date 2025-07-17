package com.assignment.data.models
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DobApiModel(
    @SerialName("age")
    val age: Int,
    @SerialName("date")
    val date: String
)
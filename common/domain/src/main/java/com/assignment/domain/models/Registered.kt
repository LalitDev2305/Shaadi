package com.assignment.domain.models
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class Registered(
    val age: Int,
    val date: String
)
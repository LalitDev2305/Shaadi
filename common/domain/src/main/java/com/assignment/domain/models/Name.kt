package com.assignment.domain.models
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class Name(
    val first: String,
    val last: String,
    val title: String
)
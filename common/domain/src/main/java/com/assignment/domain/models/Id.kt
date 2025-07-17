package com.assignment.domain.models
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class Id(
    val name: String,
    val value: String? = ""
)
package com.assignment.domain.models
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class RandomUser(
    val info: Info,
    val results: List<RandomResult>
)
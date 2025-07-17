package com.assignment.domain.models
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class Info(
    val page: Int,
    val results: Int,
    val seed: String,
    val version: String
)
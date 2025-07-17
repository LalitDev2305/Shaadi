package com.assignment.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RandomUserApiModel(
    @SerialName("info")
    val info: InfoApiModel,
    @SerialName("results")
    val results: List<ResultApiModel>
)
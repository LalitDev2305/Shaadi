package com.assignment.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocationApiModel(
    @SerialName("street")
    val street: StreetApiModel,
    @SerialName("city")
    val city: String,
    @SerialName("state")
    val state: String,
    @SerialName("country")
    val country: String,
    @Serializable(with = PostcodeSerializer::class)
    val postcode: String,
    @SerialName("coordinates")
    val coordinates: CoordinatesApiModel,
    @SerialName("timezone")
    val timezone: TimezoneApiModel
)
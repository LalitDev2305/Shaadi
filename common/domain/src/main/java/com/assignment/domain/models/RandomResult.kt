package com.assignment.domain.models
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

enum class UserStatus {
    PENDING, ACCEPTED, REJECTED
}

data class RandomResult(
    val cell: String,
    val dob: Dob,
    val email: String,
    val gender: String,
    val id: Id,
    val location: Location,
    val login: Login,
    val name: Name,
    val nat: String,
    val phone: String,
    val picture: Picture,
    val registered: Registered,
    val status: String = ""
)
package com.assignment.data.models
import com.assignment.data.models.DobApiModel
import com.assignment.data.models.IdApiModel
import com.assignment.data.models.LocationApiModel
import com.assignment.data.models.LoginApiModel
import com.assignment.data.models.NameApiModel
import com.assignment.data.models.PictureApiModel
import com.assignment.data.models.RegisteredApiModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultApiModel(
    @SerialName("cell")
    val cell: String,
    @SerialName("dob")
    val dob: DobApiModel,
    @SerialName("email")
    val email: String,
    @SerialName("gender")
    val gender: String,
    @SerialName("id")
    val id: IdApiModel,
    @SerialName("location")
    val location: LocationApiModel,
    @SerialName("login")
    val login: LoginApiModel,
    @SerialName("name")
    val name: NameApiModel,
    @SerialName("nat")
    val nat: String,
    @SerialName("phone")
    val phone: String,
    @SerialName("picture")
    val picture: PictureApiModel,
    @SerialName("registered")
    val registered: RegisteredApiModel
)
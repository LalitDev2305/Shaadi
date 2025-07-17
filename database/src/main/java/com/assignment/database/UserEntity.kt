package com.assignment.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.assignment.domain.models.Dob
import com.assignment.domain.models.Id
import com.assignment.domain.models.Location
import com.assignment.domain.models.Login
import com.assignment.domain.models.Name
import com.assignment.domain.models.Picture
import com.assignment.domain.models.Registered

@Entity(tableName = "users")
data class UserEntity(
    val cell: String,
    val dob: Dob,
    val email: String,
    val gender: String,
    @PrimaryKey val id: Id,
    val location: Location,
    val login: Login, // ✅ This is key!
    val name: Name,
    val nat: String,
    val phone: String,
    val picture: Picture,
    val registered: Registered,
    val status: String = ""
)
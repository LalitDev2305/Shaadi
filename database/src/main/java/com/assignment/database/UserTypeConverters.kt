package com.assignment.database

import androidx.room.TypeConverter
import com.assignment.domain.models.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class UserTypeConverters {

    private val gson = Gson()

    @TypeConverter
    fun fromDob(dob: Dob): String = gson.toJson(dob)

    @TypeConverter
    fun toDob(dob: String): Dob =
        gson.fromJson(dob, object : TypeToken<Dob>() {}.type)

    @TypeConverter
    fun fromId(id: Id): String = gson.toJson(id)

    @TypeConverter
    fun toId(id: String): Id =
        gson.fromJson(id, object : TypeToken<Id>() {}.type)

    @TypeConverter
    fun fromLocation(location: Location): String = gson.toJson(location)

    @TypeConverter
    fun toLocation(location: String): Location =
        gson.fromJson(location, object : TypeToken<Location>() {}.type)

    @TypeConverter
    fun fromLogin(login: Login): String = gson.toJson(login)

    @TypeConverter
    fun toLogin(login: String): Login =
        gson.fromJson(login, object : TypeToken<Login>() {}.type)

    @TypeConverter
    fun fromName(name: Name): String = gson.toJson(name)

    @TypeConverter
    fun toName(name: String): Name =
        gson.fromJson(name, object : TypeToken<Name>() {}.type)

    @TypeConverter
    fun fromPicture(picture: Picture): String = gson.toJson(picture)

    @TypeConverter
    fun toPicture(picture: String): Picture =
        gson.fromJson(picture, object : TypeToken<Picture>() {}.type)

    @TypeConverter
    fun fromRegistered(registered: Registered): String = gson.toJson(registered)

    @TypeConverter
    fun toRegistered(registered: String): Registered =
        gson.fromJson(registered, object : TypeToken<Registered>() {}.type)
}
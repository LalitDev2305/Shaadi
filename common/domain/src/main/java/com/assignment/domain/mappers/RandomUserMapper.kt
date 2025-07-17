package com.assignment.domain.mappers

import com.assignment.data.models.CoordinatesApiModel
import com.assignment.data.models.DobApiModel
import com.assignment.data.models.IdApiModel
import com.assignment.data.models.InfoApiModel
import com.assignment.data.models.LocationApiModel
import com.assignment.data.models.LoginApiModel
import com.assignment.data.models.NameApiModel
import com.assignment.data.models.PictureApiModel
import com.assignment.data.models.RegisteredApiModel
import com.assignment.data.models.ResultApiModel
import com.assignment.data.models.StreetApiModel
import com.assignment.data.models.TimezoneApiModel
import com.assignment.domain.models.Coordinates
import com.assignment.domain.models.Dob
import com.assignment.domain.models.Id
import com.assignment.domain.models.Info
import com.assignment.domain.models.Location
import com.assignment.domain.models.Login
import com.assignment.domain.models.Name
import com.assignment.domain.models.Picture
import com.assignment.domain.models.RandomResult
import com.assignment.domain.models.Registered
import com.assignment.domain.models.Street
import com.assignment.domain.models.Timezone
import com.assignment.utils.Mapper
import javax.inject.Inject

class RandomUserMapper @Inject constructor() : Mapper<ResultApiModel, RandomResult> {

    override fun map(from: ResultApiModel): RandomResult =
        RandomResult(
            cell = from.cell,
            dob = mapDob(from.dob),
            email = from.email,
            gender = from.gender,
            id = mapID(from.id),
            location = mapLocation(from.location),
            login = mapLogin(from.login),
            name = mapName(from.name),
            nat = from.nat,
            phone = from.phone,
            picture = mapPicture(from.picture),
            registered = mapRegistered(from.registered)
        )

    private fun mapInfo(from: InfoApiModel) = Info(
        page = from.page, results = from.results, seed = from.seed, version = from.version,
    )


    private fun mapResult(from: ResultApiModel) = RandomResult(
        cell = from.cell,
        dob = mapDob(from.dob),
        email = from.email,
        gender = from.gender,
        id = mapID(from.id),
        location = mapLocation(from.location),
        login = mapLogin(from.login),
        name = mapName(from.name),
        nat = from.nat,
        phone = from.phone,
        picture = mapPicture(from.picture),
        registered = mapRegistered(from.registered)
    )

}

private fun mapDob(from: DobApiModel) = Dob(
    age = from.age, date = from.date
)

private fun mapID(from: IdApiModel) = Id(
    name = from.name, value = from.value
)

private fun mapLocation(from: LocationApiModel) = Location(
    city = from.city,
    coordinates = mapCoordinates(from.coordinates),
    country = from.country,
    postcode = from.postcode,
    state = from.state,
    street = mapStreet(from.street),
    timezone = mapTimezone(from.timezone)
)

private fun mapLogin(from: LoginApiModel) = Login(
    md5 = from.md5,
    password = from.password,
    salt = from.salt,
    sha1 = from.sha1,
    sha256 = from.sha256,
    username = from.username,
    uuid = from.uuid
)

private fun mapName(from: NameApiModel) = Name(
    first = from.first, last = from.last, title = from.title
)

private fun mapPicture(from: PictureApiModel) = Picture(
    large = from.large, medium = from.medium, thumbnail = from.thumbnail
)

private fun mapRegistered(from: RegisteredApiModel) = Registered(
    age = from.age, date = from.date
)

private fun mapCoordinates(from: CoordinatesApiModel) = Coordinates(
    latitude = from.latitude, longitude = from.longitude
)

private fun mapStreet(from: StreetApiModel) = Street(
    name = from.name, number = from.number
)

private fun mapTimezone(from: TimezoneApiModel) = Timezone(
    description = from.description, offset = from.offset
)

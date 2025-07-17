package com.assignment.database

import com.assignment.domain.UserLocalDataSource
import com.assignment.domain.models.RandomResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserLocalDataSourceImpl @Inject constructor(
    private val userDao: UserDao
) : UserLocalDataSource {

    override suspend fun insertUser(user: RandomResult) {

        val entity = UserEntity(
            cell = user.cell,
            dob = user.dob,
            email = user.email,
            gender = user.gender,
            id = user.id,
            location = user.location,
            login = user.login,
            name = user.name,
            nat = user.nat,
            phone = user.phone,
            picture = user.picture,
            registered = user.registered,
            status = user.status

        )
        userDao.insert(entity)
    }

    override fun getAllUsers(): Flow<List<RandomResult>> {
        return userDao.getAll().map { entities ->
            entities.map {
                RandomResult(
                    cell = it.cell,
                    dob = it.dob,
                    email = it.email,
                    gender = it.gender,
                    id = it.id,
                    location = it.location,
                    login = it.login,
                    name = it.name,
                    nat = it.nat,
                    phone = it.phone,
                    picture = it.picture,
                    registered = it.registered,
                    status = it.status // include status
                )
            }
        }
    }

    override suspend fun updateUserStatus(userId: String, status: String) {
        userDao.updateUserStatus(userId, status)
    }

}
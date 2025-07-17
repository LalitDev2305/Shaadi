package com.assignment.data

import com.assignment.data.models.RandomUserApiModel
import com.assignment.network.NetworkResult
import com.assignment.network.http.RequestHandler
import javax.inject.Inject


class RandomUsersRepositoryImpl @Inject constructor(
    private val requestHandler: RequestHandler,
) : RandomUsersRepository {
    override suspend fun getRandomUsers(page: Int): NetworkResult<RandomUserApiModel> {
        return requestHandler.get(
            urlPathSegments = listOf("api"),
            queryParams = mapOf("results" to 10)
        )
    }
}
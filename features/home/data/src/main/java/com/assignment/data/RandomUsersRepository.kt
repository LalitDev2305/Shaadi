package com.assignment.data

import com.assignment.data.models.RandomUserApiModel
import com.assignment.network.NetworkResult
import com.assignment.network.Paged
import com.assignment.network.Response

typealias PaginatedRandomUser = Response<Paged<RandomUserApiModel>>

interface RandomUsersRepository {
    suspend fun getRandomUsers(page: Int): NetworkResult<RandomUserApiModel>
}
package com.assignment.domain

import com.assignment.data.RandomUsersRepository
import com.assignment.data.models.ResultApiModel
import com.assignment.domain.mappers.RandomUserMapper
import com.assignment.domain.models.RandomResult
import com.assignment.domain.models.Resource
import com.assignment.network.NetworkResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RandomUsersUseCase @Inject constructor(
    private val repository: RandomUsersRepository,
    private val localDataSource: UserLocalDataSource, // Room DAO wrapper
    private val mapper: RandomUserMapper,
) {
    suspend fun invoke(page: Int = 0): Resource<List<RandomResult>> {
        return when (val result = repository.getRandomUsers(page)) {
            is NetworkResult.Error -> result.toResourceError()
            is NetworkResult.Success -> {
                // Save to Room
                result.result.results.forEach {
                    localDataSource.insertUser(mapper.map(it))
                }
                getResult(result.result.results)

            }
        }
    }

    private fun getResult(data: List<ResultApiModel>): Resource.Success<List<RandomResult>> {
        return Resource.Success(data.map { mapper.map(it) })
    }

    fun getUsersFromDb(): Flow<List<RandomResult>> {
        return localDataSource.getAllUsers()
    }

    suspend operator fun invoke(userId: String, status: String) {
        localDataSource.updateUserStatus(userId, status)
    }

}

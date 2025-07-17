package com.assignment.domain

import com.assignment.domain.models.RandomResult
import kotlinx.coroutines.flow.Flow

interface UserLocalDataSource {
    suspend fun insertUser(user: RandomResult)
    suspend fun updateUserStatus(userId: String, status: String)
    fun getAllUsers(): Flow<List<RandomResult>>

}
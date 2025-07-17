package com.assignment.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: UserEntity)

    @Query("SELECT * FROM users")
    fun getAll(): Flow<List<UserEntity>>

    @Query("UPDATE users SET status = :status WHERE phone = :userId")
    suspend fun updateUserStatus(userId: String, status: String)

    @Query("SELECT * FROM users WHERE  phone = :userId LIMIT 1")
    suspend fun xgetUserById(userId: String): UserEntity?
}
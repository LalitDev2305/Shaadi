package com.assignment.shaadi.di

import android.content.Context
import androidx.room.Room
import com.assignment.database.AppDatabase
import com.assignment.database.UserDao
import com.assignment.database.UserLocalDataSourceImpl
import com.assignment.domain.UserLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "shaadi.db"
        ).build()

    @Provides
    fun provideUserDao(db: AppDatabase): UserDao = db.userDao()

    @Provides
    fun provideLocalDataSource(userDao: UserDao): UserLocalDataSource =
        UserLocalDataSourceImpl(userDao)
}
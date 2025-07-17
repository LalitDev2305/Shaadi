package com.assignment.shaadi.di

import com.assignment.data.RandomUsersRepository
import com.assignment.data.RandomUsersRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
object CommonModule {

    @Provides
    fun provideRandomUsersRepository(impl: RandomUsersRepositoryImpl): RandomUsersRepository = impl
}
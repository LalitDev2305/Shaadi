package com.assignment.shaadi.di

import com.assignment.network.http.RequestHandler
import com.assignment.network.http.ShaadiHttpClientBuilder
import com.assignment.shaadi.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.http.URLProtocol


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideHttpClient(): HttpClient =
        ShaadiHttpClientBuilder()
            .protocol(URLProtocol.HTTPS)
            .host(BuildConfig.SHAADI_HOST)
            .build()

    @Provides
    fun provideRequestHandler(client: HttpClient) = RequestHandler(client)
}
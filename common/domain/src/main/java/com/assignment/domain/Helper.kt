package com.assignment.domain

import com.assignment.domain.models.Resource
import com.assignment.domain.models.ResourceError
import com.assignment.network.NetworkException
import com.assignment.network.NetworkResult

fun NetworkResult.Error<*>.toResourceError(): Resource.Error {
    return when (exception) {
        is NetworkException.NotFoundException -> Resource.Error(ResourceError.SERVICE_UNAVAILABLE)
        is NetworkException.UnauthorizedException -> Resource.Error(ResourceError.UNAUTHORIZED)
        is NetworkException.UnknownException -> Resource.Error(ResourceError.UNKNOWN)
    }
}
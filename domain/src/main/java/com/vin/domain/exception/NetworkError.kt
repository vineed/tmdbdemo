package com.vin.domain.exception

sealed class GenericException(message: String): Throwable(message) {
    object NetworkError : GenericException("Network Failure")
}

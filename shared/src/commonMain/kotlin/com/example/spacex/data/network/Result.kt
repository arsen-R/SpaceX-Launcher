package com.example.spacex.data.network

sealed interface Result<out T> {
    object Loading: Result<Nothing>
    data class Success<T>(val data: T): Result<T>
    data class Error(val throwable: Throwable): Result<Nothing>
}
package me.okawa.domain.repository

sealed class Result<out T> {
    data class Success<out T>(val value: T): Result<T>()
    data class NetworkError(val code: Int? = null, val message: String?): Result<Nothing>()
    data class GenericError(val message: String?): Result<Nothing>()
}
package me.okawa.androidexperiment.core.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

abstract class BaseRepository {
    suspend fun <T>callApi(context: CoroutineDispatcher, apiCall: suspend () -> T): Result<T> {
        return withContext(context) {
            try {
                Result.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is IOException -> Result.Error(message = throwable.message)
                    is HttpException -> {
                        val message = throwable.message()
                        Result.Error(message)
                    }
                    else -> Result.Error(throwable.message)
                }
            }
        }
    }
}
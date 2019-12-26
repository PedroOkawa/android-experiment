package me.okawa.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import me.okawa.domain.repository.Result
import retrofit2.HttpException
import java.io.IOException

abstract class BaseRepository {

    suspend fun <T>callApi(context: CoroutineDispatcher, apiCall: suspend () -> T): Result<T> {
        return withContext(context) {
            try {
                Result.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is IOException -> Result.GenericError(message = throwable.message)
                    is HttpException -> {
                        val code = throwable.code()
                        val message = throwable.message()
                        Result.NetworkError(code, message)
                    }
                    else -> Result.GenericError(throwable.message)
                }
            }
        }
    }

}
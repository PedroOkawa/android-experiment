package me.okawa.androidexperiment.core.feature.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.spacexdata.com/v3/"
private const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"

object AppModule {

    private val appApiModule = module {
        single { retrieveOkHttpClient() }
        single { retrieveGson() }
        single { retrieveRetrofit(get(), get()) }
    }

    private fun retrieveOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }

    private fun retrieveGson(): Gson {
        return GsonBuilder().setDateFormat(DATE_FORMAT).create()
    }

    private fun retrieveRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val modules = listOf(appApiModule)

}
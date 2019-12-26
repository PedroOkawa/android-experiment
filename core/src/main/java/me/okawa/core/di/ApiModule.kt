package me.okawa.core.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import me.okawa.data.api.SpaceXApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val MODULE_NAME = "Network Module"
private const val BASE_URL = "https://api.spacexdata.com/v3/"
private const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"

val networkModule = Kodein.Module(MODULE_NAME) {
    bind<OkHttpClient>() with singleton { retrieveOkHttpClient() }
    bind<Gson>() with singleton { retrieveGson() }
    bind<Retrofit>() with singleton {
        retrieveRetrofit(
            instance(),
            instance()
        )
    }
    bind<SpaceXApi>() with singleton {
        retrieveSpaceXApi(
            instance()
        )
    }
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

private fun retrieveSpaceXApi(retrofit: Retrofit): SpaceXApi {
    return retrofit.create(SpaceXApi::class.java)
}
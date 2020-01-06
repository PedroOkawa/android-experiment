package me.okawa.home.feature.di

import me.okawa.home.data.api.SpaceXApi
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit

private const val MODULE_NAME = "Home Api Module"

val homeApiModule = Kodein.Module(MODULE_NAME) {
    bind<SpaceXApi>() with singleton {
        retrieveSpaceXApi(
            instance()
        )
    }
}
private fun retrieveSpaceXApi(retrofit: Retrofit): SpaceXApi {
    return retrofit.create(SpaceXApi::class.java)
}
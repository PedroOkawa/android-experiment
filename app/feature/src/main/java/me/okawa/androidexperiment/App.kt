package me.okawa.androidexperiment

import android.app.Application
import me.okawa.core.feature.di.appApiModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule

class App: Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy(allowSilentOverride = true) {
        import(androidXModule(this@App))
        import(appApiModule)
    }

}
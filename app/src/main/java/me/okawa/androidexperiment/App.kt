package me.okawa.androidexperiment

import android.app.Application
import me.okawa.core.di.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

class App: Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@App))
        import(networkModule)
        import(repositoriesModule)
        import(useCasesModule)
        bind<Kodein>() with singleton { kodein }
    }

}
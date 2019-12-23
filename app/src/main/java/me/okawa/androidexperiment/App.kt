package me.okawa.androidexperiment

import android.app.Application
import me.okawa.core.networkModule
import me.okawa.core.repositoriesModule
import me.okawa.core.useCasesModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule

class App: Application(), KodeinAware {

    override val kodein: Kodein = Kodein {
        import(androidXModule(this@App))
        import(networkModule)
        import(repositoriesModule)
        import(useCasesModule)
    }

}
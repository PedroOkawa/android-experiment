package me.okawa.androidexperiment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme
import me.okawa.androidexperiment.di.viewModelsModule
import me.okawa.androidexperiment.feature.MainViewModel
import me.okawa.androidexperiment.di.MainViewModelFactory
import me.okawa.androidexperiment.feature.MainViewModel.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {

    override val kodein = Kodein.lazy {
        extend(retrieveKodein())
        import(viewModelsModule)
    }

    private val mainViewModeFactory: MainViewModelFactory by instance()

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this, mainViewModeFactory).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModel()
    }

    private fun setupViewModel() {
        with(viewModel) {
            viewState.observe(this@MainActivity, Observer<ViewState> { launches -> onViewState(launches) })
        }
    }

    private fun onViewState(viewState: ViewState?) {
        setContent {
            MaterialTheme {
                viewState?.buildUI()
            }
        }
    }
}
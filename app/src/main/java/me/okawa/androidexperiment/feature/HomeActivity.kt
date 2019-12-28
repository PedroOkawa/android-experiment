package me.okawa.androidexperiment.feature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme
import me.okawa.androidexperiment.di.viewModelsModule
import me.okawa.androidexperiment.di.HomeViewModelFactory
import me.okawa.androidexperiment.utils.retrieveKodein
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class HomeActivity : AppCompatActivity(), KodeinAware {
    override val kodein = Kodein.lazy {
        extend(retrieveKodein())
        import(viewModelsModule)
    }

    private val homeViewModeFactory: HomeViewModelFactory by instance()

    private val viewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this, homeViewModeFactory).get(HomeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.viewState.observe(this@HomeActivity, Observer<HomeViewState> { launches -> onViewState(launches) })
    }

    private fun onViewState(viewState: HomeViewState?) {
        setContent {
            MaterialTheme {
                viewState?.buildUI()
            }
        }
    }
}
package me.okawa.androidexperiment.feature

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme
import me.okawa.androidexperiment.utils.retrieveKodein
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class LauncherActivity : AppCompatActivity(), KodeinAware {
    override val kodein = Kodein.lazy {
        extend(retrieveKodein())
        //import(viewModelsModule)
    }

    /*
    private val homeViewModeFactory: HomeViewModelFactory by instance()

    private val viewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this, homeViewModeFactory).get(HomeViewModel::class.java)
    }
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModel()
        val intent = Intent(Intent.ACTION_VIEW).setClassName("me.okawa.androidexperiment", "me.okawa.home.feature.HomeActivity")
        startActivity(intent)
    }

    private fun setupViewModel() {
        //viewModel.viewState.observe(this@HomeActivity, Observer<HomeViewState> { launches -> onViewState(launches) })
    }

    /*
    private fun onViewState(viewState: HomeViewState?) {
        setContent {
            MaterialTheme { viewState?.buildUI() }
        }
    }
     */
}
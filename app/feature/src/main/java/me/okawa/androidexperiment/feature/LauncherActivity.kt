package me.okawa.androidexperiment.feature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.okawa.androidexperiment.R
import me.okawa.androidexperiment.utils.retrieveKodein
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

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
        setContentView(R.layout.activity_launcher)
        setupViewModel()
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
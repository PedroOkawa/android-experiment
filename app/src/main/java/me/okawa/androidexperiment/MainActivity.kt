package me.okawa.androidexperiment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import me.okawa.androidexperiment.di.viewModelsModule
import me.okawa.androidexperiment.feature.MainViewModel
import me.okawa.androidexperiment.model.Launch
import me.okawa.androidexperiment.di.MainViewModelFactory
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
        setContent {
            MaterialTheme {
                Greeting("Android")
            }
        }
        setupViewModel()
    }

    private fun setupViewModel() {
        with(viewModel) {
            launches.observe(this@MainActivity, Observer<List<Launch>> { launches -> onLaunches(launches) })
            loadData()
        }
    }

    private fun onLaunches(launches: List<Launch>?) {

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        Greeting("Android")
    }
}

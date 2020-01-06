package me.okawa.androidexperiment.home.feature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme
import me.okawa.androidexperiment.home.feature.di.*
import me.okawa.androidexperiment.utils.retrieveKodein
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class HomeFragment : Fragment(), KodeinAware {
    override val kodein = Kodein.lazy {
        extend(retrieveKodein())
        import(homeApiModule)
        import(repositoriesModule)
        import(homeUseCasesModule)
        import(viewModelsModule)
    }

    private val homeViewModeFactory: HomeViewModelFactory by instance()

    private val viewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this, homeViewModeFactory).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_base, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.viewState.observe(viewLifecycleOwner, Observer<HomeViewState> { launches -> onViewState(launches) })
    }

    private fun onViewState(viewState: HomeViewState?) {
        (view as ViewGroup).setContent {
            MaterialTheme { viewState?.buildUI() }
        }
    }
}
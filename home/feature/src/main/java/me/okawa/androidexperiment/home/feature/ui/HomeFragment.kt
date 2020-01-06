package me.okawa.androidexperiment.home.feature.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.ui.material.MaterialTheme
import me.okawa.androidexperiment.core.feature.BaseFragment
import me.okawa.androidexperiment.home.feature.R
import me.okawa.androidexperiment.home.feature.di.HomeModule
import me.okawa.androidexperiment.utils.setContent
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.module.Module

class HomeFragment : BaseFragment() {

    override val modules: List<Module> = HomeModule.modules

    private val homeViewModel: HomeViewModel by viewModel()

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
        homeViewModel.viewState.observe(viewLifecycleOwner, Observer<HomeViewState> { launches -> onViewState(launches) })
    }

    private fun onViewState(viewState: HomeViewState?) {
        setContent {
            MaterialTheme { viewState?.buildUI() }
        }
    }
}
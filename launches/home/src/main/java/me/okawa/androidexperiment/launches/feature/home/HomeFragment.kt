package me.okawa.androidexperiment.launches.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.lifecycle.Observer
import androidx.ui.material.MaterialTheme
import me.okawa.androidexperiment.core.feature.ui.BaseFragment
import me.okawa.androidexperiment.R
import me.okawa.androidexperiment.launches.feature.di.LaunchesModule
import me.okawa.androidexperiment.launches.feature.home.HomeViewModel.*
import me.okawa.androidexperiment.utils.navigateTo
import me.okawa.androidexperiment.utils.setContent
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.module.Module

class HomeFragment : BaseFragment() {

    override val modules: List<Module> = LaunchesModule.modules

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_base, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        registerBackPressListener()
        setupViewModel()
    }

    private fun registerBackPressListener() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            if (isEnabled) {
                viewModel.onBackPressed()
            }
        }
    }

    private fun setupViewModel() {
        with(viewModel) {
            navigation.observe(viewLifecycleOwner, Observer { onNavigation(it) })
            viewState.observe(viewLifecycleOwner, Observer { onViewState(it) })
        }
    }

    private fun onNavigation(navigation: Navigation?) {
        when(navigation) {
            is Navigation.Details -> onDetails(navigation.flightNumber)
            is Navigation.Finish -> onFinish()
        }
    }

    private fun onDetails(flightNumber: Int) {
        val direction = HomeFragmentDirections.actionToDetails(flightNumber)
        navigateTo(direction)
    }

    private fun onFinish() {
        requireActivity().finish()
    }

    private fun onViewState(viewState: HomeViewState?) {
        setContent {
            MaterialTheme { viewState?.buildUI() }
        }
    }
}
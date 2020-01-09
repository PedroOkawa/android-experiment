package me.okawa.androidexperiment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import me.okawa.androidexperiment.R
import me.okawa.androidexperiment.core.feature.ui.BaseFragment
import me.okawa.androidexperiment.di.LauncherModule
import me.okawa.androidexperiment.utils.navigateTo
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.module.Module

class LauncherFragment : BaseFragment() {

    override val modules: List<Module> = LauncherModule.modules

    private val launcherViewModel: LauncherViewModel by viewModel()

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
        with (launcherViewModel) {
            navigation.observe(viewLifecycleOwner, Observer<LauncherViewModel.Navigation>(::onNavigation))
            openHome()
        }
    }

    private fun onNavigation(navigation: LauncherViewModel.Navigation?) {
        when (navigation) {
            LauncherViewModel.Navigation.Home -> onNavigateHome()
        }
    }

    private fun onNavigateHome() {
        val direction = LauncherFragmentDirections.actionToLaunches()
        navigateTo(direction)
    }

}
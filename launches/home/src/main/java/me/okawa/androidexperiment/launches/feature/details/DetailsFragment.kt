package me.okawa.androidexperiment.launches.feature.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.ui.material.MaterialTheme
import me.okawa.androidexperiment.core.feature.ui.BaseFragment
import me.okawa.androidexperiment.R
import me.okawa.androidexperiment.launches.feature.di.LaunchesModule.PROPERTY_FLIGHT_NUMBER
import me.okawa.androidexperiment.utils.setContent
import org.koin.android.ext.android.getKoin
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : BaseFragment() {

    private val detailsViewModel: DetailsViewModel by viewModel()

    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_base, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setInjectProperties()
        setupViewModel()
    }

    private fun setInjectProperties() {
        getKoin().setProperty(PROPERTY_FLIGHT_NUMBER, args.flightNumber)
    }

    private fun setupViewModel() {
        detailsViewModel.viewState.observe(viewLifecycleOwner, Observer<DetailsViewState> { launches -> onViewState(launches) })
    }

    private fun onViewState(viewState: DetailsViewState?) {
        setContent {
            MaterialTheme { viewState?.buildUI() }
        }
    }
}
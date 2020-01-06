package me.okawa.androidexperiment.core.feature

import android.os.Bundle
import androidx.fragment.app.Fragment
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module

abstract class BaseFragment : Fragment() {

    protected abstract val modules: List<Module>

    private val loadModules by lazy {
        loadKoinModules(modules)
    }

    private fun injectFeature() = loadModules

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        injectFeature()
    }

}
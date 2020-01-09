package me.okawa.androidexperiment.utils

import android.os.Bundle
import android.view.ViewGroup
import androidx.compose.Composable
import androidx.compose.CompositionContext
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.ui.core.setContent

fun Fragment.setContent(content: @Composable() () -> Unit): CompositionContext? {
    return (view as ViewGroup).setContent(content)
}

fun Fragment.navigateTo(actionId: Int, bundle: Bundle? = null, navOptions: NavOptions? = null) {
    findNavController().navigate(actionId, bundle, navOptions)
}

fun Fragment.navigateTo(navDirections: NavDirections) {
    findNavController().navigate(navDirections.actionId, navDirections.arguments)
}
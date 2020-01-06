package me.okawa.androidexperiment.utils

import android.view.ViewGroup
import androidx.compose.Composable
import androidx.compose.CompositionContext
import androidx.fragment.app.Fragment
import androidx.ui.core.setContent

fun Fragment.setContent(content: @Composable() () -> Unit): CompositionContext? {
    return (view as ViewGroup).setContent(content)
}
package me.okawa.androidexperiment.utils

import android.app.Activity
import me.okawa.androidexperiment.App
import org.kodein.di.Kodein

fun Activity.retrieveKodein(): Kodein {
    return (application as? App)?.kodein ?: throw ClassCastException()
}
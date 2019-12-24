package me.okawa.androidexperiment

import android.app.Activity
import org.kodein.di.Kodein

fun Activity.retrieveKodein(): Kodein {
    return (application as? App)?.kodein ?: throw ClassCastException()
}
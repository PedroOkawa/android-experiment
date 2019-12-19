package me.okawa.androidexperiment.manager

import android.content.Context

class AssetsManager constructor(
    private val context: Context
) {
    fun readFromAssets(fileName: String): String {
        return context.assets.open(fileName).bufferedReader().use {it.readText()}
    }

}
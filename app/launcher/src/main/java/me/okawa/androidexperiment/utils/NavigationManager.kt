package me.okawa.androidexperiment.utils

import android.content.Intent
import java.lang.IllegalArgumentException

class NavigationManager {

    fun generateIntent(classType: Class<*>): Intent {
        return classType.`package`?.name?.let { packageName ->
            val className = classType.name
            Intent(Intent.ACTION_VIEW).setClassName(packageName, className)
        } ?: throw IllegalArgumentException()
    }
}
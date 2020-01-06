package me.okawa.home.feature.composable

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Dp
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.layout.HeightSpacer
import androidx.ui.material.surface.Surface
import androidx.ui.res.colorResource
import me.okawa.androidexperiment.R
import me.okawa.home.feature.model.Launch

@Composable
fun launchesListView(launches: List<Launch>) {
    val backgroundColor = +colorResource(R.color.color_background_launches_view)
    Surface(color = backgroundColor) {
        VerticalScroller {
            Column {
                HeightSpacer(Dp(2.0f))
                launches.forEach { launch ->
                    launchView(launch)
                }
            }
        }
    }
}

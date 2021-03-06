package me.okawa.androidexperiment.launches.feature.composable

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Dp
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.layout.HeightSpacer
import androidx.ui.material.surface.Surface
import androidx.ui.res.colorResource
import me.okawa.androidexperiment.R
import me.okawa.androidexperiment.launches.feature.model.Launch

@Composable
fun launchesListView(launches: List<Launch>, onLaunchClick: (Int) -> Unit) {
    val backgroundColor = +colorResource(R.color.color_background_launches_view)
    Surface(color = backgroundColor) {
        VerticalScroller {
            Column {
                HeightSpacer(Dp(2.0f))
                launches.forEach { launch ->
                    Clickable(onClick = {
                        onLaunchClick(launch.flightNumber)
                    }, children = {
                        launchView(launch)
                    })
                }
            }
        }
    }
}

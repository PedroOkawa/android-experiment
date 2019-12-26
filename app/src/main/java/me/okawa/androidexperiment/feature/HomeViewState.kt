package me.okawa.androidexperiment.feature

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Alignment
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.*
import androidx.ui.res.imageResource
import androidx.ui.text.ParagraphStyle
import androidx.ui.text.style.TextAlign
import androidx.ui.tooling.preview.Preview
import me.okawa.androidexperiment.R
import me.okawa.androidexperiment.model.Launch
import me.okawa.core.ui.ViewState

sealed class HomeViewState : ViewState

data class ShowLaunches(val launches: List<Launch>): HomeViewState() {
    override fun buildUI() {
        launchesListView(launches)
    }
}

data class NetworkError(val message: String): HomeViewState() {
    override fun buildUI() {
        errorView(message)
    }
}

data class GenericError(val message: String): HomeViewState() {
    override fun buildUI() {
        errorView(message)
    }
}

@Composable
private fun launchesListView(launches: List<Launch>) {
    VerticalScroller {
        Column {
            HeightSpacer(2.dp)
            launches.forEach { launch ->
                launchView(launch)
            }
        }
    }
}

@Composable
private fun launchView(launch: Launch) {
    Column(modifier = Spacing(8.dp)) {
        Text(launch.missionName, maxLines = 1)
        Text(launch.details, maxLines = 3)
    }
}

@Preview
@Composable
private fun previewErrorView() {
    errorView(message = "Json parse error")
}

@Composable
private fun errorView(message: String) {
    val errorImage = +imageResource(R.drawable.ic_error)
    Align(alignment = Alignment.Center) {
        FlexColumn(modifier = Spacing(16.dp), crossAxisAlignment = CrossAxisAlignment.Center) {
            inflexible {
                Container(width = 64.dp, height = 64.dp) {
                    DrawImage(image = errorImage)
                }
                HeightSpacer(height = 8.dp)
                Text("Ops! Something went wrong.", paragraphStyle = ParagraphStyle(textAlign = TextAlign.Center))
                HeightSpacer(height = 8.dp)
                Text("Caused by:\n$message", paragraphStyle = ParagraphStyle(textAlign = TextAlign.Center))
            }
        }
    }
}
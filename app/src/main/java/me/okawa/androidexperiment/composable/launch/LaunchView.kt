package me.okawa.androidexperiment.composable.launch

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.TextUnit
import androidx.ui.core.dp
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.layout.FlexRow
import androidx.ui.layout.Spacing
import androidx.ui.material.surface.Card
import androidx.ui.res.colorResource
import androidx.ui.res.imageResource
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.tooling.preview.Preview
import me.okawa.androidexperiment.R
import me.okawa.androidexperiment.composable.image.image
import me.okawa.androidexperiment.model.Launch

@Preview
@Composable
private fun previewLaunchView() {
    val launch = Launch(
        0,
        "Mission Name",
        emptyList(),
        false,
        "2019",
        null,
        false,
        "Tentative Max Precision",
        false,
        null,
        false,
        "Launch Details",
        null
    )
    launchView(launch)
}

@Composable
fun launchView(launch: Launch) {
    val backgroundColor = +colorResource(R.color.color_background_launch_view)
    val textColor = +colorResource(R.color.color_text_launch_view)
    Card(
        color = backgroundColor,
        shape = RoundedCornerShape(4.dp),
        elevation = 6.dp,
        modifier = Spacing(
            left = 12.dp,
            top = 6.dp,
            right = 12.dp,
            bottom = 6.dp
        )
    ) {
        FlexRow(modifier = Spacing(8.dp)) {
            inflexible {
                val image = +image(
                    launch.links?.missionPatch
                )
                    ?: +imageResource(R.drawable.ic_placeholder)
                Container(
                    modifier = Spacing(8.dp),
                    width = 48.dp,
                    height = 48.dp
                ) {
                    DrawImage(image = image)
                }
            }
            expanded(flex = 1.0f) {
                Column {
                    Text(
                        text = launch.missionName,
                        modifier = Spacing(
                            left = 8.dp,
                            top = 4.dp,
                            right = 8.dp,
                            bottom = 4.dp
                        ),
                        maxLines = 1,
                        style = TextStyle(
                            color = textColor,
                            fontSize = TextUnit.Sp(18),
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = launch.details,
                        modifier = Spacing(
                            left = 8.dp,
                            top = 4.dp,
                            right = 8.dp,
                            bottom = 4.dp
                        ),
                        maxLines = 2,
                        style = TextStyle(
                            color = textColor,
                            fontSize = TextUnit.Sp(14)
                        )
                    )
                }
            }
        }
    }
}
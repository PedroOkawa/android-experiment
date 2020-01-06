package me.okawa.home.feature.composable

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Dp
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
import me.okawa.home.feature.model.Launch

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
        shape = RoundedCornerShape(Dp(4.0f)),
        elevation = Dp(6.0f),
        modifier = Spacing(
            left = Dp(12.0f),
            top = Dp(6.0f),
            right = Dp(12.0f),
            bottom = Dp(6.0f)
        )
    ) {
        FlexRow(modifier = Spacing(Dp(8.0f))) {
            inflexible {
                val image = +image(
                    launch.links?.missionPatch
                )
                    ?: +imageResource(R.drawable.ic_placeholder)
                Container(
                    modifier = Spacing(Dp(8.0f)),
                    width = Dp(48.0f),
                    height = Dp(48.0f)
                ) {
                    DrawImage(image = image)
                }
            }
            expanded(flex = 1.0f) {
                Column {
                    Text(
                        text = launch.missionName,
                        modifier = Spacing(
                            left = Dp(8.0f),
                            top = Dp(4.0f),
                            right = Dp(8.0f),
                            bottom = Dp(4.0f)
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
                            left = Dp(8.0f),
                            top = Dp(4.0f),
                            right = Dp(8.0f),
                            bottom = Dp(4.0f)
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
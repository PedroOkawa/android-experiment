package me.okawa.androidexperiment.composable.error

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Alignment
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.DrawImage
import androidx.ui.layout.*
import androidx.ui.res.imageResource
import androidx.ui.text.ParagraphStyle
import androidx.ui.text.style.TextAlign
import androidx.ui.tooling.preview.Preview
import me.okawa.androidexperiment.R

@Preview
@Composable
private fun previewErrorView() {
    errorView(message = "Json parse error")
}

@Composable
fun errorView(message: String) {
    val errorImage = +imageResource(R.drawable.ic_error)
    Align(alignment = Alignment.Center) {
        FlexColumn(modifier = Spacing(16.dp), crossAxisAlignment = CrossAxisAlignment.Center) {
            inflexible {
                Container(width = 64.dp, height = 64.dp) {
                    DrawImage(image = errorImage)
                }
                HeightSpacer(height = 8.dp)
                Text(
                    text = "Ops! Something went wrong.",
                    paragraphStyle = ParagraphStyle(textAlign = TextAlign.Center)
                )
                HeightSpacer(height = 8.dp)
                Text(
                    text = "Caused by:\n$message",
                    paragraphStyle = ParagraphStyle(textAlign = TextAlign.Center)
                )
            }
        }
    }
}
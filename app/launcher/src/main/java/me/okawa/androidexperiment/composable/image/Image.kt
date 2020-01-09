package me.okawa.androidexperiment.composable.image

import android.graphics.Bitmap
import androidx.annotation.CheckResult
import androidx.compose.effectOf
import androidx.compose.memo
import androidx.compose.onCommit
import androidx.compose.state
import androidx.core.graphics.drawable.toBitmap
import androidx.ui.graphics.Image
import androidx.ui.graphics.ImageConfig
import androidx.ui.graphics.colorspace.ColorSpaces
import coil.Coil
import coil.api.newGetBuilder
import coil.request.GetRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@CheckResult(suggest = "+")
fun image(data: Any?) = effectOf<Image?> {
    data?.let {
        val request = +memo(it) {
            Coil.loader().newGetBuilder().data(it).build()
        }
        +image(request)
    }
}

@CheckResult(suggest = "+")
fun image(request: GetRequest) = effectOf<Image?> {
    val image = +state<Image?> { null }

    +onCommit(request) {
        val job = CoroutineScope(Dispatchers.Main.immediate).launch {
            val drawable = Coil.loader().get(request)
            image.value =
                RemoteImage(drawable.toBitmap())
        }

        onDispose { job.cancel() }
    }

    image.value
}

class RemoteImage(private val bitmap: Bitmap) : Image {
    override val width = bitmap.width
    override val height = bitmap.height
    override val config = ImageConfig.Argb8888
    override val colorSpace = ColorSpaces.Srgb
    override val hasAlpha = bitmap.hasAlpha()
    override val nativeImage = bitmap
    override fun prepareToDraw() = bitmap.prepareToDraw()
}
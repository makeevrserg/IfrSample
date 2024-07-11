package com.flipperdevices.ifrmvp.core.ui.layout.core

import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.flipperdevices.ifrmvp.core.ui.util.GridConstants


val LocalScaleFactor = compositionLocalOf { ScaleFactor(1f, 1f) }

class ScaleFactor(
    val widthScaleFactor: Float,
    val heightScaleFactor: Float,
) {
    val scaleFactor = minOf(widthScaleFactor, heightScaleFactor)

    val width = GridConstants.SCALE_WIDTH * scaleFactor
    val height = GridConstants.SCALE_HEIGHT * scaleFactor
}

@Composable
fun BoxWithConstraintsScope.rememberScaleFactor(): ScaleFactor {
    return remember(maxWidth, maxHeight) {
        ScaleFactor(
            widthScaleFactor = maxWidth / GridConstants.SCALE_WIDTH.dp,
            heightScaleFactor = maxHeight / GridConstants.SCALE_HEIGHT.dp
        )
    }
}
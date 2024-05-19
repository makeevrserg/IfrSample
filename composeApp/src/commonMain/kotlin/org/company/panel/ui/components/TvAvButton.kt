package org.company.panel.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
internal fun TvAvButton(onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        text = "TV/AV",
        background = Color(0xFF303030)
    )
}

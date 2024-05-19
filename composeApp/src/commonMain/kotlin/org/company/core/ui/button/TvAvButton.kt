package org.company.core.ui.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.company.core.ui.button.core.TextButton

@Composable
internal fun TvAvButton(onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        text = "TV/AV",
        background = Color(0xFF303030)
    )
}

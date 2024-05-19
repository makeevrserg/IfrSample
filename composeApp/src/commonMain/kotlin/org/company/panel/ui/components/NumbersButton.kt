package org.company.panel.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
internal fun NumbersButton(onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        text = "123",
        background = Color(0xFF303030)
    )
}

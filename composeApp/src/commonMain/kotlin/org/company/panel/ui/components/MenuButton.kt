package org.company.panel.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
internal fun MenuButton(onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        text = "MENU",
        background = Color(0xFF303030)
    )
}

package org.company.panel.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PowerOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter

@Composable
internal fun PowerButton(onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        background = Color(0xFFF63F3F),
        painter = rememberVectorPainter(Icons.Default.PowerOff),
        iconTint = MaterialTheme.colors.onPrimary
    )
}
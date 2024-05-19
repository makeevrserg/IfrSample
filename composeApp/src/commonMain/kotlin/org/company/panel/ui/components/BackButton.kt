package org.company.panel.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Reply
import androidx.compose.material.icons.filled.Reply
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter

@Composable
internal fun BackButton(onClick: () -> Unit) {
    SquareIconButton(
        onClick = onClick,
        background = Color(0xFF303030),
        painter = rememberVectorPainter(Icons.AutoMirrored.Filled.Reply),
        iconTint = MaterialTheme.colors.onPrimary
    )
}

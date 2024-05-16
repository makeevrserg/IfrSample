package org.company.panel.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter

@Composable
internal fun UnknownButton(onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        background = Color.Gray,
        painter = rememberVectorPainter(Icons.Default.Error),
        iconTint = MaterialTheme.colors.error
    )
}
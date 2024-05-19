package org.company.core.ui.button

import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import org.company.core.ui.button.core.SquareIconButton

@Composable
internal fun InfoButton(onClick: () -> Unit) {
    SquareIconButton(
        onClick = onClick,
        background = Color(0xFF303030),
        painter = rememberVectorPainter(Icons.Outlined.Info),
        iconTint = MaterialTheme.colors.onPrimary
    )
}

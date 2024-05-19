package org.company.core.ui.button

import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SettingsPower
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import org.company.core.ui.button.core.SquareIconButton

@Composable
internal fun PowerButton(onClick: () -> Unit) {
    SquareIconButton(
        onClick = onClick,
        background = Color(0xFFF63F3F),
        painter = rememberVectorPainter(Icons.Default.SettingsPower),
        iconTint = MaterialTheme.colors.onPrimary
    )
}

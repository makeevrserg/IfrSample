package org.company.core.ui.button.core

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
internal fun SquareIconButton(
    onClick: () -> Unit,
    painter: Painter,
    background: Color,
    iconTint: Color,
    contentDescription: String? = null,
    modifier: Modifier = Modifier,
) {
    SquareButton(
        modifier = modifier,
        onClick = onClick,
        background = background
    ) {
        Icon(
            painter = painter,
            contentDescription = contentDescription,
            tint = iconTint,
            modifier = Modifier.fillMaxSize().padding(12.dp)
        )
    }
}

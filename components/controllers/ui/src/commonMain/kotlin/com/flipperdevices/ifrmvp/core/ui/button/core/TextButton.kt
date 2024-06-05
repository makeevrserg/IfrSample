package com.flipperdevices.ifrmvp.core.ui.button.core

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit

@Composable
fun TextButton(
    background: Color = Color(0xFF303030),
    textColor: Color = MaterialTheme.colors.onPrimary,
    fontSize: TextUnit = MaterialTheme.typography.caption.fontSize,
    modifier: Modifier = Modifier,
    text: String,
    onClick: (() -> Unit)?
) {
    SquareButton(
        onClick = onClick,
        background = background,
        modifier = modifier,
        content = {
            Text(
                text = text,
                style = MaterialTheme.typography.caption.copy(fontSize = fontSize),
                color = textColor,
            )
        }
    )
}

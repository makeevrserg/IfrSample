package org.company.grid.ui.content

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun BoxWithConstraintsScope.GridItemComposable(
    row: Float,
    column: Float,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    val offset = rememberDpOffset(row, column)
    Box(
        modifier = modifier.offset(x = offset.x, y = offset.y),
        content = content
    )
}

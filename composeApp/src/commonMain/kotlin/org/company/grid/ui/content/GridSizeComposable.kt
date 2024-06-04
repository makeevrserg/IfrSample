package org.company.grid.ui.content

import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.Dp

data class GridSize(val width: Dp, val height: Dp)

@Composable
internal fun BoxWithConstraintsScope.rememberGridSize(
    maxRows: Int,
    maxColumns: Int,
    maxWidth: Dp,
    maxHeight: Dp
): GridSize {
    val calculatedWidth = this.maxWidth.coerceAtMost(maxWidth)
    val calculatedHeight = this.maxHeight.coerceAtMost(maxHeight)
    return remember(calculatedWidth, calculatedHeight) {
        GridSize(
            width = calculatedWidth / maxColumns,
            height = calculatedHeight / maxRows
        )
    }
}

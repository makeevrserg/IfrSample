package org.company.grid.ui.content

import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.DpOffset
import org.company.grid.ui.util.GridConstants.MAX_COLUMNS
import org.company.grid.ui.util.GridConstants.MAX_HEIGHT
import org.company.grid.ui.util.GridConstants.MAX_ROWS
import org.company.grid.ui.util.GridConstants.MAX_WIDTH

@Composable
internal fun BoxWithConstraintsScope.rememberDpOffset(
    row: Float,
    column: Float,
): DpOffset {
    check(row >= 0f && row < MAX_ROWS)
    check(column >= 0f && column < MAX_COLUMNS)
    val calculatedWidth = maxWidth.coerceAtMost(MAX_WIDTH)
    val calculatedHeight = maxHeight.coerceAtMost(MAX_HEIGHT)
    return remember(calculatedWidth, calculatedHeight, column, row) {
        DpOffset(
            calculatedWidth * (column / MAX_COLUMNS),
            calculatedHeight * (row / MAX_ROWS)
        )
    }
}

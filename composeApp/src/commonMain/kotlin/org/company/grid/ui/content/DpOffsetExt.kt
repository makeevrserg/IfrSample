package org.company.grid.ui.content

import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import org.company.grid.model.IfrButton
import org.company.grid.ui.util.GridConstants.MAX_COLUMNS
import org.company.grid.ui.util.GridConstants.MAX_HEIGHT
import org.company.grid.ui.util.GridConstants.MAX_ROWS
import org.company.grid.ui.util.GridConstants.MAX_WIDTH

@Composable
internal fun BoxWithConstraintsScope.rememberDpOffset(position: IfrButton.Position): DpOffset {
    check(position.y >= 0f && position.y < MAX_ROWS)
    check(position.x >= 0f && position.x < MAX_COLUMNS)
    val calculatedWidth = maxWidth.coerceAtMost(MAX_WIDTH)
    val calculatedHeight = maxHeight.coerceAtMost(MAX_HEIGHT)
    return remember(calculatedWidth, calculatedHeight, position) {
        DpOffset(
            calculatedWidth * (position.x / MAX_COLUMNS),
            calculatedHeight * (position.y / MAX_ROWS)
        )
    }
}

data class GridSize(val width: Dp, val height: Dp)

@Composable
internal fun BoxWithConstraintsScope.rememberGridSize(): GridSize {
    val calculatedWidth = maxWidth.coerceAtMost(MAX_WIDTH)
    val calculatedHeight = maxHeight.coerceAtMost(MAX_HEIGHT)
    return remember(calculatedWidth, calculatedHeight) {
        GridSize(
            width = calculatedWidth / MAX_COLUMNS,
            height = calculatedHeight / MAX_ROWS
        )
    }
}

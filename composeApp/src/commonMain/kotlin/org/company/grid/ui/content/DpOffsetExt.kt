package org.company.grid.ui.content

import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import org.company.grid.model.IfrButton

@Composable
internal fun BoxWithConstraintsScope.rememberDpOffset(
    position: IfrButton.Position,
    maxRows: Int,
    maxColumns: Int,
    maxWidth: Dp,
    maxHeight: Dp
): DpOffset {
    check(position.y >= 0f && position.y < maxRows)
    check(position.x >= 0f && position.x < maxColumns)
    val calculatedWidth = this.maxWidth.coerceAtMost(maxWidth)
    val calculatedHeight = this.maxHeight.coerceAtMost(maxHeight)
    return remember(calculatedWidth, calculatedHeight, position) {
        DpOffset(
            calculatedWidth * (position.x / maxColumns),
            calculatedHeight * (position.y / maxRows)
        )
    }
}

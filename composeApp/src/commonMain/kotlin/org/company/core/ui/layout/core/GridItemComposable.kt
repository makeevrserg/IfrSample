package org.company.core.ui.layout.core

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.zIndex
import org.company.core.ui.ext.toComposeAlignment
import org.company.grid.model.IfrButton
import org.company.grid.ui.util.GridConstants.MAX_COLUMNS
import org.company.grid.ui.util.GridConstants.MAX_HEIGHT
import org.company.grid.ui.util.GridConstants.MAX_ROWS
import org.company.grid.ui.util.GridConstants.MAX_WIDTH

@Composable
internal fun BoxWithConstraintsScope.GridItemComposable(
    position: IfrButton.Position,
    size: IfrButton.Size,
    maxRows: Int = MAX_ROWS,
    maxColumns: Int = MAX_COLUMNS,
    maxWidth: Dp = MAX_WIDTH,
    maxHeight: Dp = MAX_HEIGHT,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    val offset = rememberDpOffset(
        position = position,
        maxRows = maxRows,
        maxColumns = maxColumns,
        maxWidth = maxWidth,
        maxHeight = maxHeight
    )
    val gridSize = rememberGridSize(
        maxRows = maxRows,
        maxColumns = maxColumns,
        maxWidth = maxWidth,
        maxHeight = maxHeight
    )
    Box(
        modifier = modifier
            .size(gridSize.width * size.width, gridSize.height * size.height)
            .offset(x = offset.x, y = offset.y)
            .background(Color(position.hashCode()).copy(alpha = .5f))
            .zIndex(position.zIndex),
        contentAlignment = position.alignment.toComposeAlignment(),
        content = content
    )
}

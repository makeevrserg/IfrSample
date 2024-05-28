package org.company.grid.ui.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.zIndex
import org.company.grid.model.IfrButton

@Composable
internal fun BoxWithConstraintsScope.GridItemComposable(
    position: IfrButton.Position,
    size: IfrButton.Size,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    val offset = rememberDpOffset(position)
    val gridSize = rememberGridSize()
    Box(
        modifier = modifier
            .size(gridSize.width * size.width, gridSize.height * size.height)
            .offset(x = offset.x, y = offset.y)
            .background(Color(position.hashCode()).copy(alpha = .5f))
            .zIndex(position.zIndex),
        contentAlignment = when (position.alignment) {
            IfrButton.Alignment.CENTER -> Alignment.Center
            IfrButton.Alignment.TOP_LEFT -> Alignment.TopStart
            IfrButton.Alignment.TOP_RIGHT -> Alignment.TopEnd
            IfrButton.Alignment.BOTTOM_LEFT -> Alignment.BottomStart
            IfrButton.Alignment.BOTTOM_RIGHT -> Alignment.BottomEnd
            IfrButton.Alignment.CENTER_LEFT -> Alignment.CenterStart
            IfrButton.Alignment.CENTER_RIGHT -> Alignment.CenterEnd
        },
        content = content
    )
}

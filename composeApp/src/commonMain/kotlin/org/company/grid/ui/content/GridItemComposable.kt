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
import org.company.grid.model.IfrButton
import org.company.grid.ui.util.GridConstants.DEFAULT_BUTTON_SIZE

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
            .background(Color(position.hashCode()).copy(alpha = 1f)),
        contentAlignment = when (position.alignment) {
            IfrButton.Orientation.CENTER -> Alignment.Center
            IfrButton.Orientation.TOP_LEFT -> Alignment.TopStart
            IfrButton.Orientation.TOP_RIGHT -> Alignment.TopEnd
            IfrButton.Orientation.BOTTOM_LEFT -> Alignment.BottomStart
            IfrButton.Orientation.BOTTOM_RIGHT -> Alignment.BottomEnd
            IfrButton.Orientation.CENTER_LEFT -> Alignment.CenterStart
            IfrButton.Orientation.CENTER_RIGHT -> Alignment.CenterEnd
        },
        content = content
    )
}

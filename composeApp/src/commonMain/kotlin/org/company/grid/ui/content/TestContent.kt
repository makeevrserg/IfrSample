package org.company.grid.ui.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import org.company.core.ui.button.BackButton
import org.company.core.ui.button.ChannelButton
import org.company.core.ui.button.HomeButton
import org.company.core.ui.button.InfoButton
import org.company.core.ui.button.MenuButton
import org.company.core.ui.button.MoreButton
import org.company.core.ui.button.MuteButton
import org.company.core.ui.button.NavigationButton
import org.company.core.ui.button.NumbersButton
import org.company.core.ui.button.PowerButton
import org.company.core.ui.button.TvAvButton
import org.company.core.ui.button.VolumeButton
import org.jetbrains.compose.ui.tooling.preview.Preview

const val MAX_COLUMNS = 5
const val MAX_ROWS = 11
val MAX_WIDTH = 375.dp
val MAX_HEIGHT = 812.dp

private fun BoxWithConstraintsScope.getOffset(
    row: Float,
    column: Float,
): DpOffset {
    check(row >= 0f && row < MAX_ROWS)
    check(column >= 0f && column < MAX_COLUMNS)
    val calculatedWidth = maxWidth // .coerceAtMost(MAX_WIDTH)
    val calculatedHeight = maxHeight // .coerceAtMost(MAX_HEIGHT)
    return DpOffset(
        calculatedWidth * (column / MAX_COLUMNS),
        calculatedHeight * (row / MAX_ROWS)
    )
}

@Composable
private fun BoxWithConstraintsScope.GridItemComposable(
    row: Float,
    column: Float,
    content: @Composable () -> Unit
) {
    val offset = getOffset(row, column)
    println("Offset is $offset")
    Box(
        modifier = Modifier.offset(x = offset.x, y = offset.y).background(Color.Green)
    ) {
        content.invoke()
    }
}

@Preview
@Composable
fun TestContent() {
    Box(Modifier.fillMaxSize().padding(16.dp), Alignment.TopCenter) {
        BoxWithConstraints(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopStart
        ) {
//            (0 until MAX_ROWS).forEach { row ->
//                (0 until MAX_COLUMNS).forEach { column ->
//                    // First
//                    GridItemComposable(row.toFloat(), column.toFloat()) {
//                        Box(Modifier.size(48.dp))
//                    }
//                }
//            }
            // First
            GridItemComposable(0f, 0f) { PowerButton { } }
            GridItemComposable(0f, 2f) { MenuButton { } }
            GridItemComposable(0f, 4f) { TvAvButton { } }
            // Second
            GridItemComposable(1f, 0f) { InfoButton { } }
            GridItemComposable(1f, 1f) { HomeButton { } }
            GridItemComposable(1f, 3f) { BackButton { } }
            GridItemComposable(1f, 4f) { MoreButton { } }
            // Nav
            GridItemComposable(3f, 1f) { NavigationButton() }
            // Channel Volume
            GridItemComposable(7f, 0f) { ChannelButton { } }
            GridItemComposable(7f, 4f) { VolumeButton { } }
            // BottomButton
            GridItemComposable(10f, 0f) { NumbersButton { } }
            GridItemComposable(10f, 4f) { MuteButton { } }
        }
    }
}

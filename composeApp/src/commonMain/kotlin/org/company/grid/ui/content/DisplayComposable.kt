package org.company.grid.ui.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import org.company.core.ui.theme.AppTheme
import org.company.grid.model.Display

@Composable
internal fun BoxWithConstraintsScope.DisplayComposable(
    display: Display,
    content: @Composable BoxWithConstraintsScope.() -> Unit
) {
    GridItemComposable(
        modifier = Modifier,
        position = display.position,
        size = display.size,
        content = {
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(AppTheme.dimens.S)
                    .clip(RoundedCornerShape(AppTheme.dimens.S))
                    .background(Color.Blue),
                contentAlignment = display.position.alignment.toComposeAlignment(),
                content = content
            )
        }
    )
}

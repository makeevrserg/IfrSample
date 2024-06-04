package org.company.core.ui.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Air
import androidx.compose.material.icons.filled.TimerOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import org.company.core.ui.ext.asPainter
import org.company.grid.model.display.DisplayData
import kotlin.time.Duration

@Composable
fun DisplayDataComposable(displayData: DisplayData) {
    when (displayData) {
        is DisplayData.FanPower -> {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                content = {
                    Icon(
                        painter = rememberVectorPainter(Icons.Filled.Air),
                        tint = MaterialTheme.colors.onPrimary,
                        contentDescription = null
                    )
                    Text(
                        text = "${displayData.fanPower}",
                        color = MaterialTheme.colors.onPrimary,
                        style = MaterialTheme.typography.button
                    )
                }
            )
        }

        is DisplayData.IconOnly -> {
            Icon(
                painter = displayData.iconType.asPainter(),
                tint = MaterialTheme.colors.onPrimary,
                contentDescription = null
            )
        }

        is DisplayData.Temperature -> {
            Text(
                text = "${displayData.temperature}",
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.h4
            )
        }

        is DisplayData.TextOnly -> {
            Text(
                text = displayData.text,
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.button
            )
        }

        is DisplayData.Timer -> {
            if (displayData.duration == Duration.ZERO) {
                Icon(
                    painter = rememberVectorPainter(Icons.Filled.TimerOff),
                    tint = MaterialTheme.colors.onPrimary,
                    contentDescription = null
                )
            } else {
                Text(
                    text = displayData.duration.toString(),
                    color = MaterialTheme.colors.onPrimary,
                    style = MaterialTheme.typography.button
                )
            }
        }
    }
}

package org.company.core.ui.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.company.core.ui.button.core.TextButton

@Composable
internal fun VolumeButton(
    onAddClicked: () -> Unit,
    onReduceClicked: () -> Unit
) {
    Column(
        modifier = Modifier.clip(RoundedCornerShape(8.dp)).background(Color(0xFF303030)),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextButton(
            onClick = onAddClicked,
            text = "+",
            background = Color(0xFF303030),
            fontSize = 24.sp
        )
        TextButton(
            onClick = null,
            text = "VOL",
            background = Color(0xFF303030)
        )
        TextButton(
            onClick = onReduceClicked,
            text = "-",
            background = Color(0xFF303030),
            fontSize = 24.sp
        )
    }
}

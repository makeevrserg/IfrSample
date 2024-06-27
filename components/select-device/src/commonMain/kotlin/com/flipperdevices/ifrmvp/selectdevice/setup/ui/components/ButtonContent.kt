package com.flipperdevices.ifrmvp.selectdevice.setup.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.flipperdevices.core.ui.theme.LocalPalletV2
import com.flipperdevices.ifrmvp.backend.model.SignalResponse
import com.flipperdevices.ifrmvp.core.ui.button.UnknownButton
import com.flipperdevices.ifrmvp.core.ui.button.core.SquareIconButton
import com.flipperdevices.ifrmvp.core.ui.button.core.TextButton
import com.flipperdevices.ifrmvp.model.buttondata.IconButtonData

@Composable
private fun Button(model: SignalResponse) {
    val text = model.data.text
    val iconType = IconButtonData.IconType.entries.firstOrNull { it.name == model.data.iconId }
    when {
        text != null -> {
            TextButton(
                text = text,
                onClick = {}
            )
        }

        iconType != null -> {
            SquareIconButton(
                iconType = iconType,
                onClick = {}
            )
        }

        else -> {
            UnknownButton(onClick = {})
        }
    }
}

@Composable
internal fun ButtonContent(
    onClicked: () -> Unit,
    modifier: Modifier = Modifier,
    signalResponse: SignalResponse
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(signalResponse)
        Spacer(modifier = Modifier.height(14.dp))
        Text(
            text = "Point Flipper Zero at the TV and tap the button",
            style = MaterialTheme.typography.body2,
            color = LocalPalletV2.current.text.body.secondary,
            textAlign = TextAlign.Center,
        )
    }
}

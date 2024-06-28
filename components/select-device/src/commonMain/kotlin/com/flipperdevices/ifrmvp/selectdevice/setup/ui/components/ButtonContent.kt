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
import com.flipperdevices.ifrmvp.components.select.device.RemoteSetupR
import com.flipperdevices.ifrmvp.core.ui.button.UnknownButton
import com.flipperdevices.ifrmvp.core.ui.button.core.SquareIconButton
import com.flipperdevices.ifrmvp.core.ui.button.core.TextButton
import com.flipperdevices.ifrmvp.model.buttondata.IconButtonData
import dev.icerock.moko.resources.compose.localized
import dev.icerock.moko.resources.format

@Composable
private fun SignalResponseButton(
    model: SignalResponse,
    onClick: () -> Unit
) {
    val text = model.data.text
    val iconType = IconButtonData.IconType.entries.firstOrNull { it.name == model.data.iconId }
    when {
        text != null -> {
            TextButton(
                text = text,
                onClick = onClick
            )
        }

        iconType != null -> {
            SquareIconButton(
                iconType = iconType,
                onClick = onClick
            )
        }

        else -> {
            UnknownButton(onClick = onClick)
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
        SignalResponseButton(model = signalResponse, onClick = onClicked)
        Spacer(modifier = Modifier.height(14.dp))
        Text(
            text = RemoteSetupR.strings.point_flipper.format(signalResponse.categoryName)
                .localized(),
            style = MaterialTheme.typography.body2,
            color = LocalPalletV2.current.text.body.secondary,
            textAlign = TextAlign.Center,
        )
    }
}

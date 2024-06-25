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
import com.flipperdevices.ifrmvp.backend.model.SignalButtonInfo
import com.flipperdevices.ifrmvp.backend.model.SignalModel
import com.flipperdevices.ifrmvp.core.ui.button.core.TextButton

@Composable
internal fun ButtonContent(
    onClicked: () -> Unit,
    modifier: Modifier = Modifier,
    buttonInfo: SignalButtonInfo,
    signalModel: SignalModel
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextButton(
            text = signalModel.name,
            onClick = {}
        )
        Spacer(modifier = Modifier.height(14.dp))
        Text(
            text = "Point Flipper Zero at the TV and tap the button",
            style = MaterialTheme.typography.body2,
            color = LocalPalletV2.current.text.body.secondary,
            textAlign = TextAlign.Center,
        )
    }
}
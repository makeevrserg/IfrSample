package com.flipperdevices.ifrmvp.selectdevice.setup.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.flipperdevices.core.ui.theme.LocalPalletV2
import com.flipperdevices.ifrmvp.components.select.device.RemoteSetupR
import com.flipperdevices.ifrmvp.selectdevice.categories.ui.components.ErrorComposable
import com.flipperdevices.ifrmvp.selectdevice.setup.presentation.decompose.SetupComponent
import dev.icerock.moko.resources.compose.localized
import dev.icerock.moko.resources.desc.desc

@Composable
internal fun LoadedContent(
    model: SetupComponent.Model.Loaded,
    onPositiveClicked: () -> Unit,
    onNegativeClicked: () -> Unit,
    onDispatchSignalClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val ifrFileModel = model.response.ifrFileModel
    val signalResponse = model.response.signalResponse
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        when {
            ifrFileModel != null -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                    content = {
                        Text(
                            text = "Yappie! Found your remote!", // todo
                            style = MaterialTheme.typography.subtitle2,
                            color = LocalPalletV2.current.text.title.blackOnColor
                        )
                    }
                )
            }

            signalResponse != null -> {
                Box(modifier = Modifier)
                ButtonContent(
                    onClicked = onDispatchSignalClicked,
                    modifier = Modifier,
                    signalResponse = signalResponse
                )
                ConfirmContent(
                    text = signalResponse.message,
                    onNegativeClicked = onNegativeClicked,
                    onPositiveClicked = onPositiveClicked,
                    modifier = Modifier
                )
            }

            else -> {
                ErrorComposable(
                    desc = RemoteSetupR.strings.not_found_signal.desc().localized(),
                )
            }
        }
    }
}

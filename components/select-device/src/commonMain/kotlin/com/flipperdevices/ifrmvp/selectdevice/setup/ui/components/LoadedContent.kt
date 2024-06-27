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
import com.flipperdevices.ifrmvp.selectdevice.categories.ui.components.ErrorComposable
import com.flipperdevices.ifrmvp.selectdevice.setup.presentation.SetupComponent

@Composable
internal fun LoadedContent(
    model: SetupComponent.Model.Loaded,
    onPositiveClicked: () -> Unit,
    onNegativeClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val ifrFileModel = model.response.ifrFileModel
    val signalOrderModel = model.response.signalResponse
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
                            text = "Yappie! Found your remote!",
                            style = MaterialTheme.typography.subtitle2,
                            color = LocalPalletV2.current.text.title.blackOnColor
                        )
                    }
                )
            }

            signalOrderModel != null -> {
                Box(modifier = Modifier)
                ButtonContent(
                    onClicked = {},
                    modifier = Modifier,
                    signalResponse = signalOrderModel
                )
                ConfirmContent(
                    text = "Does TV turn on/off?",
                    onNegativeClicked = onNegativeClicked,
                    onPositiveClicked = onPositiveClicked,
                    modifier = Modifier
                )
            }

            else -> {
                ErrorComposable(
                    desc = "Not found signal for your preferences",
                )
            }
        }
    }
}

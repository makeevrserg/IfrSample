package com.flipperdevices.ifrmvp.selectdevice.setup.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.flipperdevices.ifrmvp.selectdevice.setup.presentation.SetupComponent

@Composable
internal fun LoadedContent(
    model: SetupComponent.Model.Loaded,
    onPositiveClicked: () -> Unit,
    onNegativeClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
//        if (!model.response.hasNext) {
//            Text(
//                text = "No signals",
//                style = MaterialTheme.typography.h6,
//                color = LocalPalletV2.current.text.title.blackOnColor,
//                modifier = Modifier.fillMaxWidth(),
//                textAlign = TextAlign.Center
//            )
//        } else if (model.response.signalModel == null) {
//            Text(
//                text = "No signals",
//                style = MaterialTheme.typography.h6,
//                color = LocalPalletV2.current.text.title.blackOnColor,
//                modifier = Modifier.fillMaxWidth(),
//                textAlign = TextAlign.Center
//            )
//        } else {
        Box(modifier = Modifier)
        ButtonContent(
            onClicked = {},
            modifier = Modifier,
            buttonInfo = model.response.buttonInfo
        )
        ConfirmContent(
            text = "Does TV turn on/off?",
            onNegativeClicked = onNegativeClicked,
            onPositiveClicked = onPositiveClicked,
            modifier = Modifier
        )
//        }
    }
}

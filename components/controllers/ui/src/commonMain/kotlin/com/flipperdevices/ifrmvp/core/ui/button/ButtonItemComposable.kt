package com.flipperdevices.ifrmvp.core.ui.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.flipperdevices.ifrmvp.core.ui.button.core.SquareIconButton
import com.flipperdevices.ifrmvp.core.ui.button.core.TextButton
import com.flipperdevices.ifrmvp.model.IfrKeyData
import com.flipperdevices.ifrmvp.model.buttondata.Base64ImageButtonData
import com.flipperdevices.ifrmvp.model.buttondata.ButtonData
import com.flipperdevices.ifrmvp.model.buttondata.ChannelButtonData
import com.flipperdevices.ifrmvp.model.buttondata.IconButtonData
import com.flipperdevices.ifrmvp.model.buttondata.NavigationButtonData
import com.flipperdevices.ifrmvp.model.buttondata.TextButtonData
import com.flipperdevices.ifrmvp.model.buttondata.UnknownButtonData
import com.flipperdevices.ifrmvp.model.buttondata.VolumeButtonData

@Composable
fun ButtonItemComposable(
    buttonData: ButtonData,
    onKeyDataClicked: (IfrKeyData) -> Unit,
) {
    when (buttonData) {
        is IconButtonData -> {
            SquareIconButton(buttonData.iconType) { onKeyDataClicked.invoke(buttonData.keyData) }
        }

        is ChannelButtonData -> {
            ChannelButton(
                onNextClicked = { onKeyDataClicked.invoke(buttonData.add) },
                onPrevClicked = { onKeyDataClicked.invoke(buttonData.reduce) }
            )
        }

        is VolumeButtonData -> {
            VolumeButton(
                onAddClicked = { onKeyDataClicked.invoke(buttonData.add) },
                onReduceClicked = { onKeyDataClicked.invoke(buttonData.reduce) },
            )
        }

        is NavigationButtonData -> {
            NavigationButton(
                onLeftClicked = { onKeyDataClicked.invoke(buttonData.left) },
                onRightClicked = { onKeyDataClicked.invoke(buttonData.right) },
                onDownClicked = { onKeyDataClicked.invoke(buttonData.down) },
                onUpClicked = { onKeyDataClicked.invoke(buttonData.up) },
                onOkClicked = { onKeyDataClicked.invoke(buttonData.ok) }
            )
        }

        is TextButtonData -> {
            TextButton(
                onClick = { onKeyDataClicked.invoke(buttonData.keyData) },
                text = buttonData.text,
                background = Color(0xFF303030)
            )
        }

        is Base64ImageButtonData -> {
            Base64ImageButton(
                base64Icon = buttonData.base64Image,
                onClick = { onKeyDataClicked.invoke(buttonData.keyData) }
            )
        }

        UnknownButtonData -> {
            UnknownButton { }
        }
    }
}

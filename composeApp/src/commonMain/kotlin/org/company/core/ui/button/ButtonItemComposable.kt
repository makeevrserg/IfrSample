package org.company.core.ui.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.company.core.ui.button.core.TextButton
import org.company.grid.model.IfrKeyData
import org.company.grid.model.buttondata.ButtonData
import org.company.grid.model.buttondata.ChannelButtonData
import org.company.grid.model.buttondata.IconType
import org.company.grid.model.buttondata.NavigationButtonData
import org.company.grid.model.buttondata.VolumeButtonData

@Composable
internal fun ButtonItemComposable(
    buttonData: ButtonData,
    onKeyClicked: (IfrKeyData) -> Unit
) {
    when (buttonData) {
        is ButtonData.IconButtonData -> {
            when (buttonData.iconType) {
                IconType.BACK -> BackButton { onKeyClicked.invoke(buttonData.keyData) }
                IconType.HOME -> HomeButton { onKeyClicked.invoke(buttonData.keyData) }
                IconType.INFO -> InfoButton { onKeyClicked.invoke(buttonData.keyData) }
                IconType.MORE -> MoreButton { onKeyClicked.invoke(buttonData.keyData) }
                IconType.MUTE -> MuteButton { onKeyClicked.invoke(buttonData.keyData) }
                IconType.POWER -> PowerButton { onKeyClicked.invoke(buttonData.keyData) }
            }
        }

        is ChannelButtonData -> {
            ChannelButton(
                onNextClicked = { onKeyClicked.invoke(buttonData.add) },
                onPrevClicked = { onKeyClicked.invoke(buttonData.reduce) }
            )
        }

        is VolumeButtonData -> {
            VolumeButton(
                onAddClicked = { onKeyClicked.invoke(buttonData.add) },
                onReduceClicked = { onKeyClicked.invoke(buttonData.reduce) },
            )
        }

        is NavigationButtonData -> {
            NavigationButton(
                onLeftClicked = { onKeyClicked.invoke(buttonData.left) },
                onRightClicked = { onKeyClicked.invoke(buttonData.right) },
                onDownClicked = { onKeyClicked.invoke(buttonData.down) },
                onUpClicked = { onKeyClicked.invoke(buttonData.up) },
                onOkClicked = { onKeyClicked.invoke(buttonData.ok) }
            )
        }

        is ButtonData.TextButtonData -> {
            TextButton(
                onClick = { onKeyClicked.invoke(buttonData.keyData) },
                text = buttonData.text,
                background = Color(0xFF303030)
            )
        }

        is ButtonData.Base64ImageButtonData -> {
            Base64ImageButton(
                base64Icon = buttonData.base64Image,
                onClick = { onKeyClicked.invoke(buttonData.keyData) }
            )
        }

        ButtonData.UnknownButtonData -> {
            UnknownButton { }
        }

        else -> {
            UnknownButton { }
        }
    }
}

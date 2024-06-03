package org.company.core.ui.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.company.core.ui.button.core.SquareIconButton
import org.company.core.ui.button.core.TextButton
import org.company.grid.model.IfrKeyData
import org.company.grid.model.buttondata.Base64ImageButtonData
import org.company.grid.model.buttondata.ButtonData
import org.company.grid.model.buttondata.ChannelButtonData
import org.company.grid.model.buttondata.IconButtonData
import org.company.grid.model.buttondata.NavigationButtonData
import org.company.grid.model.buttondata.StatefulButtonData
import org.company.grid.model.buttondata.TextButtonData
import org.company.grid.model.buttondata.UnknownButtonData
import org.company.grid.model.buttondata.VolumeButtonData

@Composable
internal fun ButtonItemComposable(
    buttonData: ButtonData,
    onKeyClicked: (IfrKeyData) -> Unit,
) {
    when (buttonData) {
        is IconButtonData -> {
            SquareIconButton(buttonData.iconType) { onKeyClicked.invoke(buttonData.keyData) }
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

        is TextButtonData -> {
            TextButton(
                onClick = { onKeyClicked.invoke(buttonData.keyData) },
                text = buttonData.text,
                background = Color(0xFF303030)
            )
        }

        is Base64ImageButtonData -> {
            Base64ImageButton(
                base64Icon = buttonData.base64Image,
                onClick = { onKeyClicked.invoke(buttonData.keyData) }
            )
        }

        UnknownButtonData -> {
            UnknownButton { }
        }

        is StatefulButtonData.StatefulBase64ImageButtonData -> {
            Base64ImageButton(
                base64Icon = buttonData.base64Image,
                onClick = { onKeyClicked.invoke(buttonData.keyStates.first().keyData) }
            )
        }

        is StatefulButtonData.StatefulIconButtonData -> {
            SquareIconButton(buttonData.iconType) { onKeyClicked.invoke(buttonData.keyStates.first().keyData) }
        }

        is StatefulButtonData.StatefulTextButtonData -> {
            TextButton(
                onClick = { onKeyClicked.invoke(buttonData.keyStates.first().keyData) },
                text = buttonData.text,
                background = Color(0xFF303030)
            )
        }
    }
}

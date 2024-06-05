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
import org.company.grid.model.buttondata.TextButtonData
import org.company.grid.model.buttondata.UnknownButtonData
import org.company.grid.model.buttondata.VolumeButtonData

@Composable
internal fun ButtonItemComposable(
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

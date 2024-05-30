package org.company.core.ui.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.company.core.ui.button.core.TextButton
import org.company.grid.model.IfrKeyData
import org.company.grid.model.buttondata.BackButtonData
import org.company.grid.model.buttondata.Base64ImageButtonData
import org.company.grid.model.buttondata.ButtonData
import org.company.grid.model.buttondata.ChannelButtonData
import org.company.grid.model.buttondata.FanModeButtonData
import org.company.grid.model.buttondata.HomeButtonData
import org.company.grid.model.buttondata.InfoButtonData
import org.company.grid.model.buttondata.MenuButtonData
import org.company.grid.model.buttondata.MoreButtonData
import org.company.grid.model.buttondata.MuteButtonData
import org.company.grid.model.buttondata.NavigationButtonData
import org.company.grid.model.buttondata.NumbersButtonData
import org.company.grid.model.buttondata.PowerButtonData
import org.company.grid.model.buttondata.SingleKeyButtonData
import org.company.grid.model.buttondata.TextButtonData
import org.company.grid.model.buttondata.TvAvButtonData
import org.company.grid.model.buttondata.UnknownButtonData
import org.company.grid.model.buttondata.VolumeButtonData

@Composable
internal fun ButtonItemComposable(
    buttonData: ButtonData,
    onKeyClicked: (IfrKeyData) -> Unit
) {
    when (buttonData) {
        UnknownButtonData -> {
            buttonData as SingleKeyButtonData
            UnknownButton { onKeyClicked.invoke(buttonData.key) }
        }

        is PowerButtonData -> {
            PowerButton { onKeyClicked.invoke(buttonData.key) }
        }

        is HomeButtonData -> {
            HomeButton { onKeyClicked.invoke(buttonData.key) }
        }

        is MenuButtonData -> {
            MenuButton { onKeyClicked.invoke(buttonData.key) }
        }

        is TvAvButtonData -> {
            TvAvButton { onKeyClicked.invoke(buttonData.key) }
        }

        is InfoButtonData -> {
            InfoButton { onKeyClicked.invoke(buttonData.key) }
        }

        is BackButtonData -> {
            BackButton { onKeyClicked.invoke(buttonData.key) }
        }

        is MoreButtonData -> {
            MoreButton { onKeyClicked.invoke(buttonData.key) }
        }

        is NumbersButtonData -> {
            NumbersButton { onKeyClicked.invoke(buttonData.key) }
        }

        is MuteButtonData -> {
            MuteButton { onKeyClicked.invoke(buttonData.key) }
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
                onClick = { onKeyClicked.invoke(buttonData.key) },
                text = buttonData.text,
                background = Color(0xFF303030)
            )
        }

        is Base64ImageButtonData -> {
            Base64ImageButton(
                base64Icon = buttonData.base64Image,
                onClick = { onKeyClicked.invoke(buttonData.key) }
            )
        }

        is FanModeButtonData -> {
            TextButton(
                onClick = { onKeyClicked.invoke(buttonData.keyStates.random().data) },
                text = "MODE",
                background = Color(0xFF303030)
            )
        }
    }
}

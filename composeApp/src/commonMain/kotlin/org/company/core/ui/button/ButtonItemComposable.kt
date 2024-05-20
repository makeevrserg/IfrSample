package org.company.core.ui.button

import androidx.compose.runtime.Composable
import org.company.core.model.ButtonType
import org.company.grid.model.ButtonData
import org.company.grid.model.ChannelButtonData
import org.company.grid.model.KeyData
import org.company.grid.model.NavigationButtonData
import org.company.grid.model.SingleKeyButtonType
import org.company.grid.model.VolumeButtonData

@Composable
internal fun ButtonItemComposable(
    buttonData: ButtonData,
    onKeyClicked: (KeyData) -> Unit
) {
    when (buttonData.buttonType) {
        ButtonType.UNKNOWN -> {
            buttonData as SingleKeyButtonType
            UnknownButton { onKeyClicked.invoke(buttonData.key) }
        }

        ButtonType.POWER_TOGGLE -> {
            buttonData as SingleKeyButtonType
            PowerButton { onKeyClicked.invoke(buttonData.key) }
        }

        ButtonType.HOME_BUTTON -> {
            buttonData as SingleKeyButtonType
            HomeButton { onKeyClicked.invoke(buttonData.key) }
        }

        ButtonType.MENU_BUTTON -> {
            buttonData as SingleKeyButtonType
            MenuButton { onKeyClicked.invoke(buttonData.key) }
        }

        ButtonType.TV_AV_BUTTON -> {
            buttonData as SingleKeyButtonType
            TvAvButton { onKeyClicked.invoke(buttonData.key) }
        }

        ButtonType.INFO -> {
            buttonData as SingleKeyButtonType
            InfoButton { onKeyClicked.invoke(buttonData.key) }
        }

        ButtonType.HOME -> {
            buttonData as SingleKeyButtonType
            HomeButton { onKeyClicked.invoke(buttonData.key) }
        }

        ButtonType.BACK -> {
            buttonData as SingleKeyButtonType
            BackButton { onKeyClicked.invoke(buttonData.key) }
        }

        ButtonType.MORE -> {
            buttonData as SingleKeyButtonType
            MoreButton { onKeyClicked.invoke(buttonData.key) }
        }

        ButtonType.BUTTON_123 -> {
            buttonData as SingleKeyButtonType
            NumbersButton { onKeyClicked.invoke(buttonData.key) }
        }

        ButtonType.MUTE -> {
            buttonData as SingleKeyButtonType
            MuteButton { onKeyClicked.invoke(buttonData.key) }
        }

        ButtonType.BUTTON_CH -> {
            buttonData as ChannelButtonData
            ChannelButton(
                onNextClicked = { onKeyClicked.invoke(buttonData.add) },
                onPrevClicked = { onKeyClicked.invoke(buttonData.reduce) }
            )
        }

        ButtonType.BUTTON_VOL -> {
            buttonData as VolumeButtonData
            VolumeButton(
                onAddClicked = { onKeyClicked.invoke(buttonData.add) },
                onReduceClicked = { onKeyClicked.invoke(buttonData.reduce) },
            )
        }

        ButtonType.NAV -> {
            buttonData as NavigationButtonData
            NavigationButton(
                onLeftClicked = { onKeyClicked.invoke(buttonData.left) },
                onRightClicked = { onKeyClicked.invoke(buttonData.right) },
                onDownClicked = { onKeyClicked.invoke(buttonData.down) },
                onUpClicked = { onKeyClicked.invoke(buttonData.up) },
                onOkClicked = { onKeyClicked.invoke(buttonData.ok) }
            )
        }
    }
}

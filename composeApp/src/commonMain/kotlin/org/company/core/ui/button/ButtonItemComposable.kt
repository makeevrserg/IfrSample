package org.company.core.ui.button

import androidx.compose.runtime.Composable
import org.company.core.model.ButtonType

@Composable
internal fun ButtonItemComposable(buttonType: ButtonType) {
    when (buttonType) {
        ButtonType.UNKNOWN -> UnknownButton { }
        ButtonType.POWER_TOGGLE -> PowerButton { }
        ButtonType.HOME_BUTTON -> HomeButton { }
        ButtonType.MENU_BUTTON -> MenuButton { }
        ButtonType.TV_AV_BUTTON -> TvAvButton { }
        ButtonType.INFO -> InfoButton { }
        ButtonType.HOME -> HomeButton { }
        ButtonType.BACK -> BackButton { }
        ButtonType.MORE -> MoreButton { }
        ButtonType.BUTTON_123 -> NumbersButton {}
        ButtonType.MUTE -> MuteButton { }
        ButtonType.BUTTON_CH -> ChannelButton { }
        ButtonType.BUTTON_VOL -> VolumeButton { }
        ButtonType.NAV -> NavigationButton()
    }
}

package org.company.core.ui.layout

import androidx.compose.runtime.Composable
import org.company.core.ui.button.BackButton
import org.company.core.ui.button.ChannelButton
import org.company.core.ui.button.HomeButton
import org.company.core.ui.button.InfoButton
import org.company.core.ui.button.MenuButton
import org.company.core.ui.button.MoreButton
import org.company.core.ui.button.MuteButton
import org.company.core.ui.button.NavigationButton
import org.company.core.ui.button.NumbersButton
import org.company.core.ui.button.PowerButton
import org.company.core.ui.button.TvAvButton
import org.company.core.ui.button.UnknownButton
import org.company.core.ui.button.VolumeButton
import org.company.panel.model.ButtonType
import org.company.panel.model.Item

@Composable
internal fun ButtonItemComposable(item: Item) {
    item.itemData?.let { itemData ->
        when (itemData.buttonType) {
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
}

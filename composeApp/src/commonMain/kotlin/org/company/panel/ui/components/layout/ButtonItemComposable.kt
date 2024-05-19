package org.company.panel.ui.components.layout

import androidx.compose.runtime.Composable
import org.company.panel.model.ButtonType
import org.company.panel.model.Item
import org.company.panel.ui.components.BackButton
import org.company.panel.ui.components.ChannelButton
import org.company.panel.ui.components.HomeButton
import org.company.panel.ui.components.InfoButton
import org.company.panel.ui.components.MenuButton
import org.company.panel.ui.components.MoreButton
import org.company.panel.ui.components.MuteButton
import org.company.panel.ui.components.NavigationButton
import org.company.panel.ui.components.NumbersButton
import org.company.panel.ui.components.PowerButton
import org.company.panel.ui.components.TvAvButton
import org.company.panel.ui.components.UnknownButton
import org.company.panel.ui.components.VolumeButton

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

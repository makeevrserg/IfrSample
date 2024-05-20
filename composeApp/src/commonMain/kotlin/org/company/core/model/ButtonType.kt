package org.company.core.model

import kotlinx.serialization.Serializable

@Serializable
enum class ButtonType {
    UNKNOWN,
    POWER_TOGGLE,
    HOME_BUTTON,
    MENU_BUTTON,
    TV_AV_BUTTON,
    INFO,
    HOME,
    BACK,
    MORE,
    BUTTON_123,
    MUTE,
    BUTTON_CH,
    BUTTON_VOL,
    NAV
}

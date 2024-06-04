package org.company.grid.model.buttondata

import kotlinx.serialization.Serializable

@Serializable
sealed interface ButtonData {
    val type: ButtonType

    enum class ButtonType {
        UNKNOWN,
        TEXT,
        ICON,
        BASE64_IMAGE,
        CHANNEL,
        NAVIGATION,
        VOLUME,
        STATEFUL_TEXT,
        STATEFUL_ICON,
        STATEFUL_BASE64,
        STATEFUL_TEMPERATURE,
    }
}

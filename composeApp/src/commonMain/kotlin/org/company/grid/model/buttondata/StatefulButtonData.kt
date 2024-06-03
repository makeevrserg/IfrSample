package org.company.grid.model.buttondata

import kotlinx.serialization.Serializable
import org.company.grid.model.IfrKeyState

@Serializable
sealed interface StatefulButtonData : ButtonData {
    val keyStates: List<IfrKeyState>

    @Serializable
    class StatefulTextButtonData(
        override val keyStates: List<IfrKeyState>,
        val text: String
    ) : StatefulButtonData {
        override val type: ButtonData.ButtonType = ButtonData.ButtonType.STATEFUL_TEXT
    }

    @Serializable
    class StatefulIconButtonData(
        override val keyStates: List<IfrKeyState>,
        val iconType: IconButtonData.IconType
    ) : StatefulButtonData {
        override val type: ButtonData.ButtonType = ButtonData.ButtonType.STATEFUL_ICON
    }

    @Serializable
    class StatefulBase64ImageButtonData(
        override val keyStates: List<IfrKeyState>,
        val base64Image: String
    ) : StatefulButtonData {
        override val type: ButtonData.ButtonType = ButtonData.ButtonType.STATEFUL_BASE64
    }
}

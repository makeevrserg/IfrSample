package org.company.grid.model.buttondata

import kotlinx.serialization.Serializable
import org.company.grid.model.IfrKeyState
import org.company.grid.model.Visibility

@Serializable
sealed interface StatefulButtonData : ButtonData {
    val id: String
    val visibility: Visibility
    val keyStates: List<IfrKeyState>

    @Serializable
    class StatefulTextButtonData(
        override val id: String,
        override val keyStates: List<IfrKeyState>,
        override val visibility: Visibility = Visibility.Always,
        val text: String
    ) : StatefulButtonData {
        override val type: ButtonData.ButtonType = ButtonData.ButtonType.STATEFUL_TEXT
    }

    @Serializable
    class StatefulIconButtonData(
        override val id: String,
        override val keyStates: List<IfrKeyState>,
        override val visibility: Visibility = Visibility.Always,
        val iconType: IconButtonData.IconType
    ) : StatefulButtonData {
        override val type: ButtonData.ButtonType = ButtonData.ButtonType.STATEFUL_ICON
    }

    @Serializable
    class StatefulBase64ImageButtonData(
        override val id: String,
        override val keyStates: List<IfrKeyState>,
        override val visibility: Visibility = Visibility.Always,
        val base64Image: String
    ) : StatefulButtonData {
        override val type: ButtonData.ButtonType = ButtonData.ButtonType.STATEFUL_BASE64
    }
}

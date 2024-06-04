package org.company.grid.model.buttondata

import kotlinx.serialization.SerialName
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
        @SerialName("id")
        override val id: String,
        @SerialName("key_states")
        override val keyStates: List<IfrKeyState>,
        @SerialName("visibility")
        override val visibility: Visibility = Visibility.Always,
        @SerialName("text")
        val text: String
    ) : StatefulButtonData {
        override val type: ButtonData.ButtonType = ButtonData.ButtonType.STATEFUL_TEXT
    }

    @Serializable
    class StatefulIconButtonData(
        @SerialName("id")
        override val id: String,
        @SerialName("key_states")
        override val keyStates: List<IfrKeyState>,
        @SerialName("visibility")
        override val visibility: Visibility = Visibility.Always,
        @SerialName("icon_type")
        val iconType: IconButtonData.IconType
    ) : StatefulButtonData {
        override val type: ButtonData.ButtonType = ButtonData.ButtonType.STATEFUL_ICON
    }

    @Serializable
    class StatefulBase64ImageButtonData(
        @SerialName("id")
        override val id: String,
        @SerialName("key_states")
        override val keyStates: List<IfrKeyState>,
        @SerialName("visibility")
        override val visibility: Visibility = Visibility.Always,
        @SerialName("base64_image")
        val base64Image: String
    ) : StatefulButtonData {
        override val type: ButtonData.ButtonType = ButtonData.ButtonType.STATEFUL_BASE64
    }
}

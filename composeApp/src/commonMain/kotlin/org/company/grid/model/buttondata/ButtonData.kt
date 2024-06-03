package org.company.grid.model.buttondata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.IfrKeyData
import org.company.grid.model.IfrKeyState

@Serializable
sealed interface ButtonData {
    val type: ButtonType

    @Serializable
    sealed interface StateButtonData : ButtonData {
        val keyStates: List<IfrKeyState>

        @Serializable
        class Default(
            override val type: ButtonType = ButtonType.STATEFUL,
            override val keyStates: List<IfrKeyState>
        ) : StateButtonData
    }

    @Serializable
    sealed interface SingleKeyButtonData : ButtonData {
        val keyData: IfrKeyData
    }

    @Serializable
    data object UnknownButtonData : ButtonData {
        override val type: ButtonType = ButtonType.UNKNOWN
    }

    @Serializable
    data class Base64ImageButtonData(
        override val keyData: IfrKeyData,
        val base64Image: String,
    ) : SingleKeyButtonData {
        override val type: ButtonType = ButtonType.BASE64_IMAGE
    }

    @Serializable
    data class TextButtonData(
        override val keyData: IfrKeyData,
        val text: String
    ) : SingleKeyButtonData {
        @SerialName("type")
        override val type: ButtonType = ButtonType.TEXT
    }

    @Serializable
    data class IconButtonData(
        override val keyData: IfrKeyData,
        val iconType: IconType
    ) : SingleKeyButtonData {
        override val type: ButtonType = ButtonType.ICON
    }
}

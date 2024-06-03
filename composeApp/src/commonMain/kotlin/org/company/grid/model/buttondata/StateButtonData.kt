package org.company.grid.model.buttondata

import kotlinx.serialization.Serializable
import org.company.grid.model.IfrKeyState

@Serializable
sealed interface StateButtonData : ButtonData {
    val keyStates: List<IfrKeyState>

    @Serializable
    class Default(
        override val type: ButtonData.ButtonType = ButtonData.ButtonType.STATEFUL,
        override val keyStates: List<IfrKeyState>
    ) : StateButtonData
}

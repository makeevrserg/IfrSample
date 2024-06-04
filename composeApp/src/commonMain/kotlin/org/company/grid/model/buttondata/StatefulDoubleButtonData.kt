package org.company.grid.model.buttondata

import kotlinx.serialization.Serializable
import org.company.grid.model.IfrKeyState
import org.company.grid.model.Visibility

@Serializable
data class StatefulDoubleButtonData(
    override val id: String,
    override val visibility: Visibility = Visibility.Always,
    override val keyStates: List<IfrKeyState>,
    val text: String,
) : StatefulButtonData {
    override val type: ButtonData.ButtonType = ButtonData.ButtonType.STATEFUL_TEMPERATURE
}

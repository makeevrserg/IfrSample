package org.company.grid.model.buttondata

import kotlinx.serialization.Serializable
import org.company.grid.model.IfrKeyState

@Serializable
data class StatefulTemperatureButtonData(
    override val keyStates: List<IfrKeyState>
) : StatefulButtonData {
    override val type: ButtonData.ButtonType = ButtonData.ButtonType.STATEFUL_TEMPERATURE
}

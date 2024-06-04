package org.company.grid.model.buttondata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.IfrKeyState
import org.company.grid.model.Visibility

@Serializable
data class StatefulDoubleButtonData(
    @SerialName("id")
    override val id: String,
    @SerialName("visibility")
    override val visibility: Visibility = Visibility.Always,
    @SerialName("key_states")
    override val keyStates: List<IfrKeyState>,
    @SerialName("text")
    val text: String,
) : StatefulButtonData {
    override val type: ButtonData.ButtonType = ButtonData.ButtonType.STATEFUL_TEMPERATURE
}

package org.company.grid.model.buttondata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.IfrKeyState

@SerialName("FAN_MODE")
@Serializable
data class FanModeButtonData(
    override val states: List<IfrKeyState>
) : StateButtonData

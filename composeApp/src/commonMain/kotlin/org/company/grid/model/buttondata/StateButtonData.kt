package org.company.grid.model.buttondata

import kotlinx.serialization.Serializable
import org.company.grid.model.IfrKeyState

@Serializable
sealed interface StateButtonData: ButtonData {
    val states: List<IfrKeyState>
}

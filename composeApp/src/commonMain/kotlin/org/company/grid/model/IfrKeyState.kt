package org.company.grid.model

import kotlinx.serialization.Serializable
import org.company.grid.model.display.DisplayData

@Serializable
data class IfrKeyState(
    val keyData: IfrKeyData,
    val displayData: DisplayData? = null
)

package org.company.grid.model.buttondata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.KeyData

@SerialName("NAV")
@Serializable
class NavigationButtonData(
    val up: KeyData,
    val left: KeyData,
    val down: KeyData,
    val right: KeyData,
    val ok: KeyData,
) : ButtonData

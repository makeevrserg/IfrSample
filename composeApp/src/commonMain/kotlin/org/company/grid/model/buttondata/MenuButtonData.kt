package org.company.grid.model.buttondata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.KeyData

@SerialName("MENU")
@Serializable
data class MenuButtonData(
    override val key: KeyData
) : SingleKeyButtonData

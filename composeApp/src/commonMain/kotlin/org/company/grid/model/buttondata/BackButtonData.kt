package org.company.grid.model.buttondata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.KeyData

@SerialName("BACK")
@Serializable
data class BackButtonData(
    override val key: KeyData
) : SingleKeyButtonData

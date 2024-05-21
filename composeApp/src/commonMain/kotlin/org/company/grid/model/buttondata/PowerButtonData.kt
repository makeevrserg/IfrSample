package org.company.grid.model.buttondata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.KeyData

@SerialName("POWER")
@Serializable
data class PowerButtonData(
    override val key: KeyData
) : SingleKeyButtonData

package org.company.grid.model.buttondata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.IfrKeyData

@SerialName("POWER")
@Serializable
data class PowerButtonData(
    override val keyData: IfrKeyData
) : SingleKeyButtonData

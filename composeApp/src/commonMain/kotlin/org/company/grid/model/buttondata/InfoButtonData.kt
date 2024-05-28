package org.company.grid.model.buttondata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.IfrKeyData

@SerialName("INFO")
@Serializable
data class InfoButtonData(
    override val key: IfrKeyData
) : SingleKeyButtonData

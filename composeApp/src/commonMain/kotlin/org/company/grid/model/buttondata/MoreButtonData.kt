package org.company.grid.model.buttondata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.IfrKeyData

@SerialName("MORE")
@Serializable
data class MoreButtonData(
    override val key: IfrKeyData
) : SingleKeyButtonData

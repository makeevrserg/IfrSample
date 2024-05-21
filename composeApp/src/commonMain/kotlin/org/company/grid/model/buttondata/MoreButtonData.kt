package org.company.grid.model.buttondata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.KeyData

@SerialName("MORE")
@Serializable
data class MoreButtonData(
    override val key: KeyData
) : SingleKeyButtonData

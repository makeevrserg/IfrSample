package org.company.grid.model.buttondata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.KeyData

@SerialName("HOME")
@Serializable
data class HomeButtonData(
    override val key: KeyData
) : SingleKeyButtonData

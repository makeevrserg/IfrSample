package org.company.grid.model.buttondata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.IfrKeyData

@SerialName("HOME")
@Serializable
data class HomeButtonData(
    override val keyData: IfrKeyData
) : SingleKeyButtonData

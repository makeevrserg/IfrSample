package org.company.grid.model.buttondata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.IfrKeyData

@SerialName("NUMBERS")
@Serializable
data class NumbersButtonData(
    override val key: IfrKeyData
) : SingleKeyButtonData

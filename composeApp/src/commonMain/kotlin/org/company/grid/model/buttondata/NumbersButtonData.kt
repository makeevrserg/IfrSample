package org.company.grid.model.buttondata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.KeyData

@SerialName("NUMBERS")
@Serializable
class NumbersButtonData(
    override val key: KeyData
) : SingleKeyButtonData

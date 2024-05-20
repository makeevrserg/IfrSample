package org.company.grid.model.buttondata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.KeyData

@SerialName("TV_AV")
@Serializable
class TvAvButtonData(
    override val key: KeyData
) : SingleKeyButtonData

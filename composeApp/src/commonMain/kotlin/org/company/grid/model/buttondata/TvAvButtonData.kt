package org.company.grid.model.buttondata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.IfrKeyData

@SerialName("TV_AV")
@Serializable
data class TvAvButtonData(
    override val key: IfrKeyData
) : SingleKeyButtonData

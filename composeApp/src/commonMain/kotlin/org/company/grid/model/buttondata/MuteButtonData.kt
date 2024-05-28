package org.company.grid.model.buttondata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.IfrKeyData

@SerialName("MUTE")
@Serializable
data class MuteButtonData(
    override val key: IfrKeyData
) : SingleKeyButtonData

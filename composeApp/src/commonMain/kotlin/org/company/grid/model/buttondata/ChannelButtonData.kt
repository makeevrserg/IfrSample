package org.company.grid.model.buttondata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.KeyData

@SerialName("CHANNEL")
@Serializable
data class ChannelButtonData(
    val add: KeyData,
    val reduce: KeyData,
) : ButtonData

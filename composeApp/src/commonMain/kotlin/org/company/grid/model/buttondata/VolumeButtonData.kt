package org.company.grid.model.buttondata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.KeyData

@SerialName("VOL")
@Serializable
class VolumeButtonData(
    val add: KeyData,
    val reduce: KeyData,
) : ButtonData

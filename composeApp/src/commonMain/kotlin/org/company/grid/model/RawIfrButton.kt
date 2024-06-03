package org.company.grid.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class RawIfrButton(
    val data: JsonObject,
    val position: IfrButton.Position,
    val size: IfrButton.Size = IfrButton.Size()
)

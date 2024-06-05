package com.flipperdevices.ifrmvp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class RawIfrButton(
    @SerialName("data")
    val data: JsonObject,
    @SerialName("position")
    val position: IfrButton.Position,
    @SerialName("size")
    val size: IfrButton.Size = IfrButton.Size()
)

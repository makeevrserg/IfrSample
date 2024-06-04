package org.company.grid.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IfrKeyState(
    @SerialName("key_data")
    val keyData: IfrKeyData,
)

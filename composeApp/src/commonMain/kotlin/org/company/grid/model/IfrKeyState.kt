package org.company.grid.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IfrKeyState(
    val data: IfrKeyData,
    val value: String
)
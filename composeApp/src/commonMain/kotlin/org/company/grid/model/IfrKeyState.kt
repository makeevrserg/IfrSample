package org.company.grid.model

import kotlinx.serialization.Serializable

@Serializable
data class IfrKeyState(
    val keyData: IfrKeyData,
    val value: String
)
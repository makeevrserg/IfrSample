package com.flipperdevices.ifrmvp.model.buttondata

import com.flipperdevices.ifrmvp.model.IfrKeyData
import kotlinx.serialization.Serializable

@Serializable
sealed interface SingleKeyButtonData : ButtonData {
    val keyData: IfrKeyData
}

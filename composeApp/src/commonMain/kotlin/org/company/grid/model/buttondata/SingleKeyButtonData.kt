package org.company.grid.model.buttondata

import kotlinx.serialization.Serializable
import org.company.grid.model.IfrKeyData

@Serializable
sealed interface SingleKeyButtonData : ButtonData {
    val keyData: IfrKeyData
}

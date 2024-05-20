package org.company.grid.model.buttondata

import kotlinx.serialization.Serializable
import org.company.grid.model.KeyData

@Serializable
sealed interface SingleKeyButtonData : ButtonData {
    val key: KeyData
}

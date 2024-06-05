package org.company.grid.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.display.ButtonReference

@Serializable
sealed interface Visibility {
    @Serializable
    @SerialName("ACTIVE_STATE")
    class ActiveState(
        val ref: ButtonReference.ButtonAndKeyData
    ) : Visibility

    @Serializable
    @SerialName("ALWAYS")
    data object Always : Visibility
}

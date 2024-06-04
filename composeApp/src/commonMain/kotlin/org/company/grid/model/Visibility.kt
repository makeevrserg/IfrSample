package org.company.grid.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed interface Visibility {
    @Serializable
    @SerialName("ACTIVE_STATE")
    class ActiveState(
        val dataRefId: String,
        val stateRefId: String
    ) : Visibility

    @Serializable
    @SerialName("ALWAYS")
    data object Always : Visibility
}

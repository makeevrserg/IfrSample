package org.company.grid.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PageLayout(
    @SerialName("display")
    val display: Display? = null,
    @SerialName("buttons")
    val buttons: List<IfrButton>
)

package org.company.grid.model

import kotlinx.serialization.Serializable

@Serializable
data class PageLayout(
    val display: Display? = null,
    val buttons: List<IfrButton>
)

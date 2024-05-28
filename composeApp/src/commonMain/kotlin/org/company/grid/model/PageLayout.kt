package org.company.grid.model

import kotlinx.serialization.Serializable

@Serializable
data class PageLayout(
    val buttons: List<Button>
)

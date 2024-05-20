package org.company.grid.model

import kotlinx.serialization.Serializable

@Serializable
data class GridLayout(
    val buttons: List<Button>
)

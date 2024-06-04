package org.company.grid.model

import kotlinx.serialization.Serializable

@Serializable
class Display(
    val position: IfrButton.Position,
    val size: IfrButton.Size,
)

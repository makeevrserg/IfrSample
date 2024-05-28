package org.company.grid.model

import kotlinx.serialization.Serializable
import org.company.grid.model.buttondata.ButtonData

@Serializable
data class IfrButton(
    val data: ButtonData,
    val position: Position
) {
    @Serializable
    data class Position(val x: Float, val y: Float) {
        constructor(row: Int, column: Int) : this(row.toFloat(), column.toFloat())
    }
}

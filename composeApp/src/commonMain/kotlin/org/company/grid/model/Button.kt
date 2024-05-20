package org.company.grid.model

import kotlinx.serialization.Serializable
import org.company.grid.model.buttondata.ButtonData

@Serializable
data class Button(
    val data: ButtonData,
    val position: Position
) {
    @Serializable
    data class Position(val row: Float, val column: Float) {
        constructor(row: Int, column: Int) : this(row.toFloat(), column.toFloat())
    }
}

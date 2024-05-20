package org.company.grid.model

import kotlinx.serialization.Serializable

@Serializable
class Button(
    val data: ButtonData,
    val position: Position
) {
    @Serializable
    class Position(val row: Float, val column: Float) {
        constructor(row: Int, column: Int) : this(row.toFloat(), column.toFloat())
    }
}

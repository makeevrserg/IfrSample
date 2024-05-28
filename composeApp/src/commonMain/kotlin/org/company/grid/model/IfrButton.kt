package org.company.grid.model

import kotlinx.serialization.Serializable
import org.company.grid.model.buttondata.ButtonData

@Serializable
data class IfrButton(
    val data: ButtonData,
    val position: Position,
    val size: Size = Size()
) {
    @Serializable
    data class Position(
        val y: Float,
        val x: Float,
        val alignment: Orientation = Orientation.CENTER
    )

    @Serializable
    data class Size(
        val width: Float = 1f,
        val height: Float = 1f
    )

    enum class Orientation {
        CENTER, TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT, CENTER_LEFT, CENTER_RIGHT
    }
}

package org.company.grid.model

import kotlinx.serialization.Serializable
import org.company.grid.model.buttondata.ButtonData
import org.company.grid.model.serialization.IfrButtonSerializer

@Serializable(IfrButtonSerializer::class)
data class IfrButton(
    val data: ButtonData,
    val position: Position,
    val size: Size = Size()
) {
    @Serializable
    data class Position(
        val y: Float,
        val x: Float,
        val alignment: Alignment = Alignment.CENTER,
        val zIndex: Float = 1f
    )

    @Serializable
    data class Size(
        val width: Float = 1f,
        val height: Float = 1f
    )

    @Serializable
    enum class Alignment {
        CENTER, TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT, CENTER_LEFT, CENTER_RIGHT
    }
}

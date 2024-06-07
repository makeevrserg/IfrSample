package com.flipperdevices.ifrmvp.model

import com.flipperdevices.ifrmvp.model.buttondata.ButtonData
import com.flipperdevices.ifrmvp.model.serialization.IfrButtonSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(IfrButtonSerializer::class)
data class IfrButton(
    @SerialName("data")
    val data: ButtonData,
    @SerialName("position")
    val position: Position,
) {
    @Serializable
    data class Position(
        @SerialName("y")
        val y: Float,
        @SerialName("x")
        val x: Float,
        @SerialName("alignment")
        val alignment: Alignment = Alignment.CENTER,
        @SerialName("z_index")
        val zIndex: Float = 1f,
        @SerialName("container_width")
        val containerWidth: Float = 1f,
        @SerialName("container_height")
        val containerHeight: Float = 1f
    )

    @Serializable
    enum class Alignment {
        CENTER, TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT, CENTER_LEFT, CENTER_RIGHT
    }
}

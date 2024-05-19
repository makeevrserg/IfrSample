package org.company.panel.model

import kotlinx.serialization.Serializable

@Serializable
class ContainerInfo(
    val box: Box? = null,
    val column: Column? = null,
    val row: Row? = null,
) {
    @Serializable
    class Column(
        val verticalArrangement: Arrangement,
        val horizontalAlignment: HorizontalAlignment,
        val verticalSpacedBy: Int,
        val width: WidthContentSize,
        val height: HeightContentSize,
    )

    @Serializable
    class Row(
        val verticalAlignment: VerticalAlignment,
        val horizontalArrangement: Arrangement,
        val horizontalSpacedBy: Int,
        val width: WidthContentSize,
        val height: HeightContentSize,
    )

    @Serializable
    enum class WidthContentSize {
        FILL_WIDTH, WRAP_WIDTH
    }

    @Serializable
    enum class HeightContentSize {
        FILL_HEIGHT, WRAP_HEIGHT
    }

    @Serializable
    class Box(
        val alignment: Alignment,
        val width: WidthContentSize,
        val height: HeightContentSize,
    )

    @Serializable
    enum class Arrangement {
        SPACE_BETWEEN, CENTER
    }

    @Serializable
    enum class Alignment {
        TOP_LEFT, CENTER, TOP_CENTER
    }

    @Serializable
    enum class VerticalAlignment {
        CENTER
    }

    @Serializable
    enum class HorizontalAlignment {
        START, CENTER
    }
}

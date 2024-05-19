package org.company.panel.model

class ContainerInfo(
    val box: Box? = null,
    val column: Column? = null,
    val row: Row? = null,
) {
    class Column(
        val verticalArrangement: Arrangement,
        val horizontalAlignment: HorizontalAlignment,
        val verticalSpacedBy: Int,
        val width: WidthContentSize,
        val height: HeightContentSize,
    )

    class Row(
        val verticalAlignment: VerticalAlignment,
        val horizontalArrangement: Arrangement,
        val horizontalSpacedBy: Int,
        val width: WidthContentSize,
        val height: HeightContentSize,
    )

    enum class WidthContentSize {
        FILL_WIDTH, WRAP_WIDTH
    }

    enum class HeightContentSize {
        FILL_HEIGHT, WRAP_HEIGHT
    }

    class Box(
        val alignment: Alignment,
        val width: WidthContentSize,
        val height: HeightContentSize,
    )

    enum class Arrangement {
        SPACE_BETWEEN, CENTER
    }

    enum class Alignment {
        TOP_LEFT, CENTER, TOP_CENTER
    }

    enum class VerticalAlignment {
        CENTER
    }

    enum class HorizontalAlignment {
        START, CENTER
    }
}

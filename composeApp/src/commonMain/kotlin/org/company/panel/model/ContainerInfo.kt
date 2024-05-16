package org.company.panel.model

class ContainerInfo(
    val box: Box? = null,
    val column: Column? = null,
    val backgroundColor: Long,
    val clip: Int = 8
) {
    class Column(
        val verticalArrangement: Arrangement,
        val horizontalAlignment: HorizontalAlignment,
        val spacedBy: Int,
    )

    class Box(
        val alignment: Alignment
    )

    enum class Arrangement {
        SPACE_BETWEEN
    }

    enum class Alignment {
        TOP_LEFT, CENTER
    }

    enum class HorizontalAlignment {
        START, CENTER
    }
}
@file:Suppress("MaxLineLength")

package com.flipperdevices.ifrmvp.core.ui.util

import androidx.compose.ui.unit.dp

object GridConstants {
    const val MAX_COLUMNS = 5
    const val MAX_ROWS = 11
    val MAX_WIDTH = Int.MAX_VALUE.dp // 375.dp
    val MAX_HEIGHT = Int.MAX_VALUE.dp // 812.dp
    val DEFAULT_BUTTON_SIZE = 48.dp

    val TEMP_BASE64_IMAGE = let {
        "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAQAAADZc7J/AAAAIGNIUk0AAHomAACAhAAA+gAAAIDoAAB1MAAA6mAAADqYAAAXcJy6UTwAAAACYktHRAD/h4/MvwAAAAlwSFlzAAALEwAACxMBAJqcGAAAAAd0SU1FB+gGBwkJFOCdqu0AAAH5SURBVEjHxdVPSBRhGMfxz65jEJYG2haFVJQQ5KGCIiqITl26RHWQpEsJ/QFFwkuQRJc6dOnSoWNkRnSoU5cuHrI/XiMqlQI7FOuGmrAq604HIXdnZ3b3VM97mXmfZ748v9887wz/O1J17oX1ArYZ0BpTN+mebBwgiNx3uixnpgwc2my9HfpM15Z00oIrWmVK1kYPhEJDcb0FMZBZuchO3i+vnEVvNBcHSMXsLLpl0kAlIg4Qb/a8QVwT6itF1Ato1CHwxE7nhPpX7awPUNDqqYJQI7p9cyMJkIoFDFvQKCWNJl12SSvGAwpYrgCMGft7vdFxJZOZrijtM1JVTrq8y9IOjjohtOxSgpCUKQ+jpyIoSfc4X8PMrJHoOJcCAoSy5q3T5ocGzeZk/JS1wVZpKQ1RZqWJ13221gWPLLrquYsGrbHbTS1xTVXOwbQeH70wI+e9rJe2uG1RU5Kn0QgNGbVfkwPeYl67N/rN1Aso2uOObksOmTSnwzvjpizFA4IK4CkHdco77Zi8tDPyJnRprvGGpD0W1lg5ndqMG16dlNUOiiZkFRWlEgfpq9lorlTCXUMCLeYUEgC/fbepupC9RhypWpHxJV7CSrQ7bJ9Pid+Jokx5LqgoSBvUm+DCyhPbjSYDPrivrbpKrz1bPZP1/trKI6xZ8Q/jD2AukeSMMfJ/AAAAJXRFWHRkYXRlOmNyZWF0ZQAyMDI0LTA2LTA3VDA5OjA5OjExKzAwOjAwIUUsnAAAACV0RVh0ZGF0ZTptb2RpZnkAMjAyNC0wNi0wN1QwOTowOToxMSswMDowMFAYlCAAAAAodEVYdGRhdGU6dGltZXN0YW1wADIwMjQtMDYtMDdUMDk6MDk6MjArMDA6MDAv9bmoAAAAAElFTkSuQmCC"
    }
}

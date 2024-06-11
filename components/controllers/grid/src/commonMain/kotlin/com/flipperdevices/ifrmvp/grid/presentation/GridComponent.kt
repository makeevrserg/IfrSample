package com.flipperdevices.ifrmvp.grid.presentation

import com.flipperdevices.ifrmvp.model.PagesLayout
import kotlinx.coroutines.flow.StateFlow

interface GridComponent {
    val model: StateFlow<Model>

    class Model(val pagesLayout: PagesLayout)
}

package org.company.grid.ui.presentation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.company.core.IoCoroutineScope
import org.company.grid.model.GridLayout

class GridViewModel : CoroutineScope by IoCoroutineScope() {
    val layout = MutableStateFlow<Model>(Model())

    init {
        layout.update {
            val gridLayout = InMemoryGridLayoutFactory.create()
            println(Json { prettyPrint = true }.encodeToString(gridLayout))
//            val gridLayout = JsonGridLayoutFactory(File("./test_layout.json")).create()
            Model(gridLayout)
        }
    }

    data class Model(
        val gridLayout: GridLayout = GridLayout(emptyList())
    )
}

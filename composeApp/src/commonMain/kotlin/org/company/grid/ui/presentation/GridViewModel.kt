package org.company.grid.ui.presentation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import org.company.core.IoCoroutineScope
import org.company.grid.model.GridLayout
import java.io.File

class GridViewModel : CoroutineScope by IoCoroutineScope() {
    val layout = MutableStateFlow<Model>(Model())

    init {
//        layout.update {
//            val gridLayout = InMemoryGridLayoutFactory.create()
//            println(Json { prettyPrint = true }.encodeToString(gridLayout))
// //            val gridLayout = JsonGridLayoutFactory(File("./test_layout.json")).create()
//            Model(gridLayout)
//        }

        launch {
            while (isActive) {
                val factory = JsonGridLayoutFactory(File("./test_layout.json"))
                val gridLayout = kotlin.runCatching {
                    factory.create()
                }.getOrDefault(GridLayout(emptyList()))
                layout.value = Model(gridLayout)
                delay(500L)
            }
        }
    }

    data class Model(
        val gridLayout: GridLayout = GridLayout(emptyList())
    )
}

package org.company.grid.ui.presentation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.company.core.IoCoroutineScope
import org.company.grid.model.IfrButton
import org.company.grid.model.PagesLayout
import org.company.grid.model.buttondata.StatefulButtonData
import java.io.File

class GridViewModel : CoroutineScope by IoCoroutineScope() {
    val layout = MutableStateFlow<Model>(Model())

    private val json = Json {
        prettyPrint = true
        encodeDefaults = true
    }

    private fun startLookupJob() {
        launch {
            while (isActive) {
                val factory = JsonGridLayoutFactory(File("./test_layout.json"))
                val pageLayout = kotlin.runCatching {
                    factory.create()
                }.getOrDefault(PagesLayout(emptyList()))
                layout.value = Model(pageLayout)
                delay(500L)
            }
        }
    }

    private fun startInMemoryJob() {
        layout.update {
            val gridLayout = FanGridLayoutFactory.create()
            val file = File("./temp_json.json")
            if (!file.exists()) file.createNewFile()
            file.writeText(json.encodeToString(gridLayout))
            Model(gridLayout)
        }
    }

    fun onButtonClicked(button: IfrButton) {
        val statefulButtonData = button.data as? StatefulButtonData ?: return
        layout.update {
            val map = it.stateToIndex.toMutableMap()
            val currentIndex = (map.getOrDefault(statefulButtonData, 0) + 1)
            map[statefulButtonData] = currentIndex % statefulButtonData.keyStates.size
            it.copy(stateToIndex = map.toMap())
        }
    }

    init {
        startInMemoryJob()
//        startLookupJob()
    }

    data class Model(
        val pagesLayout: PagesLayout = PagesLayout(emptyList()),
        val stateToIndex: Map<StatefulButtonData, Int> = emptyMap()
    )
}

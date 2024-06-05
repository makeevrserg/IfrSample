package org.company.grid.ui.presentation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import org.company.core.IoCoroutineScope
import org.company.grid.model.IfrButton
import org.company.grid.model.IfrKeyState
import org.company.grid.model.PagesLayout
import org.company.grid.model.buttondata.StatefulButtonData
import org.company.grid.ui.presentation.layout.data.InMemoryPagesRepository
import org.company.grid.ui.presentation.layout.data.PagesRepository

class GridViewModel : CoroutineScope by IoCoroutineScope() {
    private val pagesRepository: PagesRepository = InMemoryPagesRepository
    val layout = MutableStateFlow(Model())

    fun onStateButtonClicked(button: IfrButton, ifrKeyState: IfrKeyState) {
        val data = button.data as? StatefulButtonData ?: return
        layout.update {
            val map = it.stateToIndex.toMutableMap()
            val newIndex = data.keyStates.indexOf(ifrKeyState)
            map[data] = newIndex
            it.copy(stateToIndex = map.toMap())
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
        pagesRepository
            .pagesFlow()
            .onEach { pagesLayout -> layout.update { model -> model.copy(pagesLayout = pagesLayout) } }
            .launchIn(this)
    }

    data class Model(
        val pagesLayout: PagesLayout = PagesLayout(emptyList()),
        val stateToIndex: Map<StatefulButtonData, Int> = emptyMap()
    )
}

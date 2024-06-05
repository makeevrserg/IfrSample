package org.company.grid.ui.presentation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import org.company.core.IoCoroutineScope
import org.company.grid.model.PagesLayout
import org.company.grid.ui.presentation.layout.data.InMemoryPagesRepository
import org.company.grid.ui.presentation.layout.data.PagesRepository

class GridViewModel : CoroutineScope by IoCoroutineScope() {
//    private val pagesRepository: PagesRepository = LookupPagesRepository
    private val pagesRepository: PagesRepository = InMemoryPagesRepository
    val layout = MutableStateFlow(Model())

    init {
        pagesRepository
            .pagesFlow()
            .onEach { pagesLayout -> layout.update { model -> model.copy(pagesLayout = pagesLayout) } }
            .launchIn(this)
    }

    data class Model(
        val pagesLayout: PagesLayout = PagesLayout(emptyList()),
    )
}

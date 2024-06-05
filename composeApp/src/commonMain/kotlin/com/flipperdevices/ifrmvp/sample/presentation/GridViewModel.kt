package com.flipperdevices.ifrmvp.sample.presentation

import com.flipperdevices.ifrmvp.core.IoCoroutineScope
import com.flipperdevices.ifrmvp.model.PagesLayout
import com.flipperdevices.ifrmvp.sample.presentation.data.InMemoryPagesRepository
import com.flipperdevices.ifrmvp.sample.presentation.data.PagesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update

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

package com.flipperdevices.ifrmvp.grid.presentation.feature

import com.flipperdevices.ifrmvp.grid.presentation.data.PagesRepository
import com.flipperdevices.ifrmvp.model.PagesLayout
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.astrainteractive.klibs.mikro.extensions.arkivanov.CoroutineFeature

internal class GridFeature(
    pagesRepository: PagesRepository
) : CoroutineFeature by CoroutineFeature.Main() {
    val layout = MutableStateFlow(PagesLayout(emptyList()))

    init {
        pagesRepository
            .pagesFlow()
            .onEach { pagesLayout -> layout.value = pagesLayout }
            .launchIn(this)
    }
}

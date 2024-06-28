package com.flipperdevices.ifrmvp.grid.presentation.feature

import com.flipperdevices.ifrmvp.grid.presentation.data.PagesRepository
import com.flipperdevices.ifrmvp.grid.presentation.decompose.GridComponent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.astrainteractive.klibs.mikro.extensions.arkivanov.CoroutineFeature

internal class GridFeature(
    private val pagesRepository: PagesRepository,
    private val param: GridComponent.Param
) : CoroutineFeature by CoroutineFeature.Main() {
    val model = MutableStateFlow<GridComponent.Model>(GridComponent.Model.Loading)

    fun tryLoad() {
        launch {
            val result = pagesRepository.fetchPages(
                ifrFileId = param.ifrFileId,
                uiFileId = param.uiFileId ?: -1
            )
            result
                .onFailure { model.value = GridComponent.Model.Error }
                .onSuccess { pagesLayout -> model.value = GridComponent.Model.Loaded(pagesLayout) }
        }
    }

    init {
        tryLoad()
    }
}

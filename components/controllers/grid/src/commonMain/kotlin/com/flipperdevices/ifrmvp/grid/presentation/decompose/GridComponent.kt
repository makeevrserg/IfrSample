package com.flipperdevices.ifrmvp.grid.presentation.decompose

import com.arkivanov.decompose.ComponentContext
import com.flipperdevices.ifrmvp.model.IfrKeyIdentifier
import com.flipperdevices.ifrmvp.model.PagesLayout
import kotlinx.coroutines.flow.StateFlow

interface GridComponent {
    val model: StateFlow<Model>

    fun onButtonClicked(identifier: IfrKeyIdentifier)
    fun tryLoad()

    sealed interface Model {
        data object Loading : Model
        data class Loaded(val pagesLayout: PagesLayout) : Model
        data object Error : Model
    }

    class Param(
        val ifrFileId: Long,
        val uiFileId: Long? = null
    )

    fun interface Factory {
        fun create(
            componentContext: ComponentContext,
            param: GridComponent.Param
        ): GridComponent
    }
}

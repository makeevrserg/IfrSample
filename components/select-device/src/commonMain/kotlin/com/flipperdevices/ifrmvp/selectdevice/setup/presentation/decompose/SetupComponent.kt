package com.flipperdevices.ifrmvp.selectdevice.setup.presentation.decompose

import com.arkivanov.decompose.ComponentContext
import com.flipperdevices.ifrmvp.backend.model.IfrFileModel
import com.flipperdevices.ifrmvp.backend.model.SignalResponseModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface SetupComponent {
    val model: StateFlow<Model>
    val remoteFoundFlow: Flow<IfrFileModel>
    val param: Param

    fun onBackClicked()

    fun onSuccessClicked()
    fun onFailedClicked()
    fun dispatchSignal()

    fun tryLoad()

    fun onFileFound(ifrFileModel: IfrFileModel)

    sealed interface Model {
        data object Loading : Model
        data class Loaded(val response: SignalResponseModel) : Model

        data object Error : Model
    }

    class Param(
        val brandId: Long,
        val categoryId: Long,
    )

    interface Factory {
        fun createSetupComponent(
            componentContext: ComponentContext,
            param: Param,
            onBack: () -> Unit,
            onIfrFileFound: (IfrFileModel) -> Unit
        ): SetupComponent
    }
}

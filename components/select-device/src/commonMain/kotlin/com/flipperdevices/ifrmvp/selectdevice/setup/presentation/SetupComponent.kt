package com.flipperdevices.ifrmvp.selectdevice.setup.presentation

import com.arkivanov.decompose.ComponentContext
import com.flipperdevices.ifrmvp.backend.model.SignalResponseModel
import kotlinx.coroutines.flow.StateFlow

interface SetupComponent {
    val model: StateFlow<Model>
    val param: Param

    fun onBackClicked()

    fun onSuccessClicked()
    fun onFailedClicked()

    fun tryLoad()

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
            onBack: () -> Unit
        ): SetupComponent
    }
}

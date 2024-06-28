package com.flipperdevices.ifrmvp.selectdevice.setup.presentation.decompose

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext

interface SetupDecomposeComponent {
    @Composable
    fun Render()

    interface Factory {
        fun createSetupComponent(
            componentContext: ComponentContext,
            param: SetupComponent.Param,
            onBack: () -> Unit
        ): SetupDecomposeComponent
    }
}

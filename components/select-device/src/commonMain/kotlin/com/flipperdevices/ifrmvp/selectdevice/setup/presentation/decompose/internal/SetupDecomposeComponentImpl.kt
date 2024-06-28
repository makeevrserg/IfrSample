package com.flipperdevices.ifrmvp.selectdevice.setup.presentation.decompose.internal

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.childContext
import com.flipperdevices.ifrmvp.selectdevice.setup.presentation.decompose.SetupComponent
import com.flipperdevices.ifrmvp.selectdevice.setup.presentation.decompose.SetupDecomposeComponent
import com.flipperdevices.ifrmvp.selectdevice.setup.ui.SetupScreen

class SetupDecomposeComponentImpl(
    componentContext: ComponentContext,
    setupComponentFactory: SetupComponent.Factory,
    param: SetupComponent.Param,
    onBack: () -> Unit
) : SetupDecomposeComponent, ComponentContext by componentContext {
    private val setupComponent = setupComponentFactory.createSetupComponent(
        componentContext = childContext("SetupComponent"),
        param = param,
        onBack = onBack
    )

    @Composable
    override fun Render() {
        SetupScreen(setupComponent = setupComponent)
    }
}

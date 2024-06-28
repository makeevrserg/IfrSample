package com.flipperdevices.ifrmvp.root.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.flipperdevices.core.ui.theme.FlipperTheme
import com.flipperdevices.ifrmvp.grid.ui.GridComposable
import com.flipperdevices.ifrmvp.root.presentation.RootComponent
import com.flipperdevices.ifrmvp.selectdevice.root.ui.SelectDeviceRootScreen

@Composable
fun RootApplicationComposable(rootComponent: RootComponent) {
    val child by rootComponent.childStack.subscribeAsState()
    FlipperTheme {
        when (val instance = child.active.instance) {
            is RootComponent.RootChild.Controller -> {
                GridComposable(instance.gridComponent)
            }

            is RootComponent.RootChild.SelectDevice -> {
                SelectDeviceRootScreen(instance.selectDeviceRootComponent)
            }
        }
    }
}

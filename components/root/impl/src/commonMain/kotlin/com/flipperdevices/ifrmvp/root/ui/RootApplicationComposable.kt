package com.flipperdevices.ifrmvp.root.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.flipperdevices.ifrmvp.grid.ui.GridScreen
import com.flipperdevices.ifrmvp.root.presentation.RootComponent
import com.flipperdevices.ifrmvp.selectdevice.root.ui.SelectDeviceRootScreen

@Composable
fun RootApplicationComposable(rootComponent: RootComponent) {
    val child by rootComponent.childStack.subscribeAsState()
    when (val instance = child.active.instance) {
        is RootComponent.RootChild.Controller -> {
            GridScreen(instance.gridComponent)
        }

        is RootComponent.RootChild.SelectDevice -> {
            SelectDeviceRootScreen(instance.selectDeviceRootComponent)
        }
    }
}

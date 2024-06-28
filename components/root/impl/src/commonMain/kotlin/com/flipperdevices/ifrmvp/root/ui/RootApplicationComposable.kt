package com.flipperdevices.ifrmvp.root.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.flipperdevices.core.ui.theme.FlipperTheme
import com.flipperdevices.ifrmvp.grid.ui.GridComposable
import com.flipperdevices.ifrmvp.root.presentation.RootComponent
import com.flipperdevices.ifrmvp.selectdevice.root.ui.SelectDeviceRootScreen

@Composable
fun RootApplicationComposable(rootComponent: RootComponent) {
    FlipperTheme {
        Children(
            stack = rootComponent.childStack,
            animation = stackAnimation(slide()),
            content = { child ->
                when (val instance = child.instance) {
                    is RootComponent.RootChild.Controller -> {
                        GridComposable(instance.gridComponent)
                    }

                    is RootComponent.RootChild.SelectDevice -> {
                        SelectDeviceRootScreen(instance.selectDeviceRootComponent)
                    }
                }
            }
        )
    }
}

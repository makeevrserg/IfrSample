package com.flipperdevices.ifrmvp.selectdevice.root.ui

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.flipperdevices.ifrmvp.selectdevice.root.presentation.SelectDeviceRootComponent

@Composable
fun SelectDeviceRootScreen(selectDeviceRootComponent: SelectDeviceRootComponent) {
    Children(
        stack = selectDeviceRootComponent.childStack,
        animation = stackAnimation(slide()),
        content = { child ->
            when (val instance = child.instance) {
                is SelectDeviceRootComponent.Child.SelectCategory -> {
                    instance.categoriesDecomposeComponent.Render()
                }

                is SelectDeviceRootComponent.Child.Brands -> {
                    instance.brandsDecomposeComponent.Render()
                }

                is SelectDeviceRootComponent.Child.Setup -> {
                    instance.setupDecomposeComponent.Render()
                }
            }
        }
    )
}

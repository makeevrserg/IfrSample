package com.flipperdevices.ifrmvp.selectdevice.root.ui

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.flipperdevices.ifrmvp.selectdevice.categories.ui.DeviceCategoriesScreen
import com.flipperdevices.ifrmvp.selectdevice.root.presentation.SelectDeviceRootComponent

@Composable
fun SelectDeviceRootScreen(selectDeviceRootComponent: SelectDeviceRootComponent) {
    Children(
        stack = selectDeviceRootComponent.childStack,
        content = { child ->
            when (val instance = child.instance) {
                is SelectDeviceRootComponent.Child.SelectCategory -> {
                    DeviceCategoriesScreen(
                        deviceCategoriesComponent = instance.deviceCategoriesComponent
                    )
                }
            }
        }
    )
}

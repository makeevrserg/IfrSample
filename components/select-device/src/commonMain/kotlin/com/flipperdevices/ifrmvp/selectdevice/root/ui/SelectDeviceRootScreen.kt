package com.flipperdevices.ifrmvp.selectdevice.root.ui

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.flipperdevices.ifrmvp.selectdevice.brands.ui.BrandsScreen
import com.flipperdevices.ifrmvp.selectdevice.categories.ui.DeviceCategoriesScreen
import com.flipperdevices.ifrmvp.selectdevice.root.presentation.SelectDeviceRootComponent
import com.flipperdevices.ifrmvp.selectdevice.setup.ui.SetupScreen

@Composable
fun SelectDeviceRootScreen(selectDeviceRootComponent: SelectDeviceRootComponent) {
    Children(
        stack = selectDeviceRootComponent.childStack,
        animation = stackAnimation(slide()),
        content = { child ->
            when (val instance = child.instance) {
                is SelectDeviceRootComponent.Child.SelectCategory -> {
                    DeviceCategoriesScreen(
                        deviceCategoriesComponent = instance.deviceCategoriesComponent
                    )
                }

                is SelectDeviceRootComponent.Child.Brands -> {
                    BrandsScreen(
                        brandsComponent = instance.brandsComponent
                    )
                }

                is SelectDeviceRootComponent.Child.Setup -> {
                    SetupScreen(
                        setupComponent = instance.setupComponent
                    )
                }
            }
        }
    )
}

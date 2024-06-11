package com.flipperdevices.ifrmvp.selectdevice.root.presentation

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.flipperdevices.ifrmvp.selectdevice.categories.presentation.DeviceCategoriesComponent

interface SelectDeviceRootComponent {
    val childStack: Value<ChildStack<*, Child>>

    sealed interface Child {
        class SelectCategory(
            val deviceCategoriesComponent: DeviceCategoriesComponent
        ) : Child
    }
}

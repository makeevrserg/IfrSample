package com.flipperdevices.ifrmvp.selectdevice.root.presentation

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.flipperdevices.ifrmvp.selectdevice.brands.presentation.BrandsComponent
import com.flipperdevices.ifrmvp.selectdevice.categories.presentation.DeviceCategoriesComponent
import com.flipperdevices.ifrmvp.selectdevice.setup.presentation.SetupComponent

interface SelectDeviceRootComponent {
    val childStack: Value<ChildStack<*, Child>>

    sealed interface Child {
        class SelectCategory(
            val deviceCategoriesComponent: DeviceCategoriesComponent
        ) : Child

        class Brands(
            val brandsComponent: BrandsComponent
        ) : Child

        class Setup(
            val setupComponent: SetupComponent
        ) : Child
    }
}

package com.flipperdevices.ifrmvp.selectdevice.root.presentation

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.flipperdevices.ifrmvp.selectdevice.brands.presentation.decompose.BrandsDecomposeComponent
import com.flipperdevices.ifrmvp.selectdevice.categories.presentation.decompose.CategoriesDecomposeComponent
import com.flipperdevices.ifrmvp.selectdevice.setup.presentation.decompose.SetupDecomposeComponent

interface SelectDeviceRootComponent {
    val childStack: Value<ChildStack<*, Child>>

    sealed interface Child {
        class SelectCategory(
            val categoriesDecomposeComponent: CategoriesDecomposeComponent
        ) : Child

        class Brands(
            val brandsDecomposeComponent: BrandsDecomposeComponent
        ) : Child

        class Setup(
            val setupDecomposeComponent: SetupDecomposeComponent
        ) : Child
    }
}

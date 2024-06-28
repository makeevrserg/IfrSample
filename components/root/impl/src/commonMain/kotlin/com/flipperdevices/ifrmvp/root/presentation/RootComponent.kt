package com.flipperdevices.ifrmvp.root.presentation

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.flipperdevices.ifrmvp.grid.presentation.decompose.GridComponent
import com.flipperdevices.ifrmvp.root.presentation.model.RootRoute
import com.flipperdevices.ifrmvp.selectdevice.root.presentation.SelectDeviceRootComponent

interface RootComponent {
    val childStack: Value<ChildStack<RootRoute, RootChild>>

    sealed interface RootChild {
        class Controller(val gridComponent: GridComponent) : RootChild
        class SelectDevice(val selectDeviceRootComponent: SelectDeviceRootComponent) : RootChild
    }
}

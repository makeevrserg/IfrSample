package com.flipperdevices.ifrmvp.root.di

import com.arkivanov.decompose.ComponentContext
import com.flipperdevices.ifrmvp.api.backend.di.ApiBackendModule
import com.flipperdevices.ifrmvp.files.di.FilesApiModule
import com.flipperdevices.ifrmvp.grid.presentation.di.ControllerModule
import com.flipperdevices.ifrmvp.root.presentation.DefaultRootComponent
import com.flipperdevices.ifrmvp.root.presentation.RootComponent
import com.flipperdevices.ifrmvp.selectdevice.root.di.SelectDeviceRootModule

interface RootModule {
    val controllerModule: ControllerModule
    val filesApiModule: FilesApiModule
    val apiBackendModule: ApiBackendModule

    fun createSelectDeviceRootModule(): SelectDeviceRootModule

    fun createRootComponent(componentContext: ComponentContext): RootComponent

    class Default : RootModule {
        override val controllerModule: ControllerModule by lazy {
            ControllerModule.Default()
        }
        override val filesApiModule: FilesApiModule by lazy {
            FilesApiModule.Default()
        }
        override val apiBackendModule: ApiBackendModule by lazy {
            ApiBackendModule.Default()
        }

        override fun createSelectDeviceRootModule(): SelectDeviceRootModule {
            return SelectDeviceRootModule.Default(
                apiBackendModule = apiBackendModule
            )
        }

        override fun createRootComponent(componentContext: ComponentContext): RootComponent {
            return DefaultRootComponent(
                componentContext = componentContext,
                controllerModule = controllerModule,
                selectDeviceRootModule = createSelectDeviceRootModule()
            )
        }
    }
}

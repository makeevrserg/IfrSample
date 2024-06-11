package com.flipperdevices.ifrmvp.selectdevice.root.di

import com.arkivanov.decompose.ComponentContext
import com.flipperdevices.ifrmvp.api.backend.di.ApiBackendModule
import com.flipperdevices.ifrmvp.selectdevice.categories.di.DeviceCategoriesModule
import com.flipperdevices.ifrmvp.selectdevice.root.presentation.DefaultSelectDeviceRootComponent
import com.flipperdevices.ifrmvp.selectdevice.root.presentation.SelectDeviceRootComponent

interface SelectDeviceRootModule {
    fun createDeviceCategoriesModule(): DeviceCategoriesModule

    fun createSelectDeviceRootComponent(componentContext: ComponentContext): SelectDeviceRootComponent

    class Default(
        private val apiBackendModule: ApiBackendModule
    ) : SelectDeviceRootModule {

        override fun createDeviceCategoriesModule(): DeviceCategoriesModule {
            return DeviceCategoriesModule.Default(
                apiBackendModule = apiBackendModule
            )
        }

        override fun createSelectDeviceRootComponent(componentContext: ComponentContext): SelectDeviceRootComponent {
            return DefaultSelectDeviceRootComponent(
                componentContext = componentContext,
                deviceCategoriesModule = createDeviceCategoriesModule()
            )
        }
    }
}

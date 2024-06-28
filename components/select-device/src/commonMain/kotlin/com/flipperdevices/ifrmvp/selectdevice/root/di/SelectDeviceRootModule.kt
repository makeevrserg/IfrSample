package com.flipperdevices.ifrmvp.selectdevice.root.di

import com.arkivanov.decompose.ComponentContext
import com.flipperdevices.ifrmvp.api.backend.di.ApiBackendModule
import com.flipperdevices.ifrmvp.backend.model.IfrFileModel
import com.flipperdevices.ifrmvp.selectdevice.brands.di.BrandsModule
import com.flipperdevices.ifrmvp.selectdevice.categories.di.DeviceCategoriesModule
import com.flipperdevices.ifrmvp.selectdevice.categories.di.DeviceCategoriesModuleImpl
import com.flipperdevices.ifrmvp.selectdevice.root.presentation.DefaultSelectDeviceRootComponent
import com.flipperdevices.ifrmvp.selectdevice.root.presentation.SelectDeviceRootComponent
import com.flipperdevices.ifrmvp.selectdevice.setup.di.SetupModule

interface SelectDeviceRootModule {
    fun createDeviceCategoriesModule(): DeviceCategoriesModule

    fun createBrandsModule(): BrandsModule

    fun createSetupModule(): SetupModule

    fun createSelectDeviceRootComponent(
        componentContext: ComponentContext,
        onBackClicked: () -> Unit,
        onIfrFileFound: (IfrFileModel) -> Unit
    ): SelectDeviceRootComponent

    class Default(
        private val apiBackendModule: ApiBackendModule
    ) : SelectDeviceRootModule {

        override fun createDeviceCategoriesModule(): DeviceCategoriesModule {
            return DeviceCategoriesModuleImpl(
                apiBackendModule = apiBackendModule
            )
        }

        override fun createBrandsModule(): BrandsModule {
            return BrandsModule.Default(
                apiBackendModule = apiBackendModule
            )
        }

        override fun createSetupModule(): SetupModule {
            return SetupModule.Default(apiBackendModule = apiBackendModule)
        }

        override fun createSelectDeviceRootComponent(
            componentContext: ComponentContext,
            onBackClicked: () -> Unit,
            onIfrFileFound: (IfrFileModel) -> Unit
        ): SelectDeviceRootComponent {
            return DefaultSelectDeviceRootComponent(
                componentContext = componentContext,
                deviceCategoriesModule = createDeviceCategoriesModule(),
                brandsModule = createBrandsModule(),
                setupModule = createSetupModule(),
                onBackClicked = onBackClicked,
                onIfrFileFound = onIfrFileFound
            )
        }
    }
}

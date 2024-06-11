package com.flipperdevices.ifrmvp.selectdevice.categories.di

import com.arkivanov.decompose.ComponentContext
import com.flipperdevices.ifrmvp.api.backend.di.ApiBackendModule
import com.flipperdevices.ifrmvp.selectdevice.categories.presentation.DefaultDeviceCategoriesComponent
import com.flipperdevices.ifrmvp.selectdevice.categories.presentation.DeviceCategoriesComponent
import com.flipperdevices.ifrmvp.selectdevice.categories.presentation.data.LocalDeviceCategoriesRepository
import com.flipperdevices.ifrmvp.selectdevice.categories.presentation.feature.DeviceCategoryListFeature
import ru.astrainteractive.klibs.mikro.core.dispatchers.DefaultKotlinDispatchers

interface DeviceCategoriesModule {
    fun createDeviceCategoriesComponent(componentContext: ComponentContext): DeviceCategoriesComponent

    @Suppress("UnusedPrivateProperty")
    class Default(
        private val apiBackendModule: ApiBackendModule
    ) : DeviceCategoriesModule {
        override fun createDeviceCategoriesComponent(
            componentContext: ComponentContext
        ): DeviceCategoriesComponent {
//            val deviceCategoriesRepository = BackendDeviceCategoriesRepository(
//                apiBackend = apiBackendModule.apiBackend,
//                dispatchers = DefaultKotlinDispatchers
//            )
            val deviceCategoriesRepository = LocalDeviceCategoriesRepository(
                dispatchers = DefaultKotlinDispatchers
            )

            return DefaultDeviceCategoriesComponent(
                componentContext = componentContext,
                createDeviceCategoryListFeature = {
                    DeviceCategoryListFeature(
                        deviceCategoriesRepository = deviceCategoriesRepository
                    )
                }
            )
        }
    }
}

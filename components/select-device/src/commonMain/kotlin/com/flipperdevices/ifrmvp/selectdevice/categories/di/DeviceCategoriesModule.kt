package com.flipperdevices.ifrmvp.selectdevice.categories.di

import com.arkivanov.decompose.ComponentContext
import com.flipperdevices.ifrmvp.api.backend.di.ApiBackendModule
import com.flipperdevices.ifrmvp.backend.model.DeviceCategory
import com.flipperdevices.ifrmvp.selectdevice.categories.presentation.DefaultDeviceCategoriesComponent
import com.flipperdevices.ifrmvp.selectdevice.categories.presentation.DeviceCategoriesComponent
import com.flipperdevices.ifrmvp.selectdevice.categories.presentation.data.BackendDeviceCategoriesRepository
import com.flipperdevices.ifrmvp.selectdevice.categories.presentation.feature.DeviceCategoryListFeature
import ru.astrainteractive.klibs.mikro.core.dispatchers.DefaultKotlinDispatchers

interface DeviceCategoriesModule {
    val deviceCategoriesFactory: DeviceCategoriesComponent.Factory

    @Suppress("UnusedPrivateProperty")
    class Default(
        private val apiBackendModule: ApiBackendModule,
    ) : DeviceCategoriesModule {

        override val deviceCategoriesFactory = object : DeviceCategoriesComponent.Factory {
            override fun createDeviceCategoriesComponent(
                componentContext: ComponentContext,
                onBackClicked: () -> Unit,
                onCategoryClicked: (DeviceCategory) -> Unit
            ): DeviceCategoriesComponent {
                val deviceCategoriesRepository = BackendDeviceCategoriesRepository(
                    apiBackend = apiBackendModule.apiBackend,
                    dispatchers = DefaultKotlinDispatchers
                )
//                val deviceCategoriesRepository = LocalDeviceCategoriesRepository(
//                    dispatchers = DefaultKotlinDispatchers
//                )

                return DefaultDeviceCategoriesComponent(
                    componentContext = componentContext,
                    onCategoryClicked = onCategoryClicked,
                    onBackClicked = onBackClicked,
                    createDeviceCategoryListFeature = {
                        DeviceCategoryListFeature(
                            deviceCategoriesRepository = deviceCategoriesRepository
                        )
                    }
                )
            }
        }
    }
}

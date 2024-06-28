package com.flipperdevices.ifrmvp.selectdevice.categories.di

import com.flipperdevices.ifrmvp.api.backend.di.ApiBackendModule
import com.flipperdevices.ifrmvp.selectdevice.categories.presentation.data.BackendDeviceCategoriesRepository
import com.flipperdevices.ifrmvp.selectdevice.categories.presentation.decompose.CategoriesDecomposeComponent
import com.flipperdevices.ifrmvp.selectdevice.categories.presentation.decompose.DeviceCategoriesComponent
import com.flipperdevices.ifrmvp.selectdevice.categories.presentation.decompose.internal.CategoriesDecomposeComponentImpl
import com.flipperdevices.ifrmvp.selectdevice.categories.presentation.decompose.internal.DefaultDeviceCategoriesComponent
import com.flipperdevices.ifrmvp.selectdevice.categories.presentation.feature.DeviceCategoryListFeature
import ru.astrainteractive.klibs.mikro.core.dispatchers.DefaultKotlinDispatchers

class DeviceCategoriesModuleImpl(
    private val apiBackendModule: ApiBackendModule,
) : DeviceCategoriesModule {

    private val deviceCategoriesFactory = let {
        DeviceCategoriesComponent.Factory { componentContext, onBackClicked, onCategoryClicked ->
            val deviceCategoriesRepository = BackendDeviceCategoriesRepository(
                apiBackend = apiBackendModule.apiBackend,
                dispatchers = DefaultKotlinDispatchers
            )
            DefaultDeviceCategoriesComponent(
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

    override val categoriesDecomposeComponentFactory = let {
        CategoriesDecomposeComponent.Factory { componentContext, onBackClicked, onCategoryClicked ->
            CategoriesDecomposeComponentImpl(
                componentContext = componentContext,
                deviceCategoriesComponentFactory = deviceCategoriesFactory,
                onBackClicked = onBackClicked,
                onCategoryClicked = onCategoryClicked
            )
        }
    }
}

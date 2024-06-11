package com.flipperdevices.ifrmvp.selectdevice.categories.presentation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.flipperdevices.ifrmvp.backend.model.DeviceCategory
import com.flipperdevices.ifrmvp.selectdevice.categories.presentation.feature.DeviceCategoryListFeature
import kotlinx.coroutines.flow.asStateFlow

internal class DefaultDeviceCategoriesComponent(
    componentContext: ComponentContext,
    createDeviceCategoryListFeature: () -> DeviceCategoryListFeature
) : DeviceCategoriesComponent,
    ComponentContext by componentContext {
    private val deviceCategoryListFeature = instanceKeeper.getOrCreate {
        createDeviceCategoryListFeature.invoke()
    }

    override val model = deviceCategoryListFeature.model.asStateFlow()

    override fun onCategoryClicked(category: DeviceCategory) = Unit

    override fun onBackClicked() = Unit
}

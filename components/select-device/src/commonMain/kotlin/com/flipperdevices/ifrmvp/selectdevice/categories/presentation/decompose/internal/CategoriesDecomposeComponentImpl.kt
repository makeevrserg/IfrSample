package com.flipperdevices.ifrmvp.selectdevice.categories.presentation.decompose.internal

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.childContext
import com.flipperdevices.ifrmvp.backend.model.DeviceCategory
import com.flipperdevices.ifrmvp.selectdevice.categories.presentation.decompose.CategoriesDecomposeComponent
import com.flipperdevices.ifrmvp.selectdevice.categories.presentation.decompose.DeviceCategoriesComponent
import com.flipperdevices.ifrmvp.selectdevice.categories.ui.DeviceCategoriesScreen

class CategoriesDecomposeComponentImpl(
    componentContext: ComponentContext,
    deviceCategoriesComponentFactory: DeviceCategoriesComponent.Factory,
    onBackClicked: () -> Unit,
    onCategoryClicked: (DeviceCategory) -> Unit
) : ComponentContext by componentContext, CategoriesDecomposeComponent {
    private val deviceCategoriesComponent = deviceCategoriesComponentFactory.create(
        componentContext = childContext("DeviceCategoriesComponent"),
        onBackClicked = onBackClicked,
        onCategoryClicked = onCategoryClicked
    )

    @Composable
    override fun Render() {
        DeviceCategoriesScreen(deviceCategoriesComponent = deviceCategoriesComponent)
    }
}

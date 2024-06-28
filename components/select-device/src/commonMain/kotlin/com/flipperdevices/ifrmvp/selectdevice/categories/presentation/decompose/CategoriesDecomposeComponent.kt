package com.flipperdevices.ifrmvp.selectdevice.categories.presentation.decompose

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.flipperdevices.ifrmvp.backend.model.DeviceCategory

interface CategoriesDecomposeComponent {
    @Composable
    fun Render()

    fun interface Factory {
        fun create(
            componentContext: ComponentContext,
            onBackClicked: () -> Unit,
            onCategoryClicked: (DeviceCategory) -> Unit
        ): CategoriesDecomposeComponent
    }
}

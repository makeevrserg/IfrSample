package com.flipperdevices.ifrmvp.selectdevice.brands.presentation.decompose

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.flipperdevices.ifrmvp.backend.model.BrandModel

interface BrandsDecomposeComponent {
    @Composable
    fun Render()

    fun interface Factory {
        fun createBrandsComponent(
            componentContext: ComponentContext,
            categoryId: Long,
            onBackClicked: () -> Unit,
            onBrandClicked: (BrandModel) -> Unit
        ): BrandsDecomposeComponent
    }
}

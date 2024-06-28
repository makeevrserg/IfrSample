package com.flipperdevices.ifrmvp.selectdevice.brands.presentation.decompose.internal

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.childContext
import com.flipperdevices.ifrmvp.backend.model.BrandModel
import com.flipperdevices.ifrmvp.selectdevice.brands.presentation.decompose.BrandsComponent
import com.flipperdevices.ifrmvp.selectdevice.brands.presentation.decompose.BrandsDecomposeComponent
import com.flipperdevices.ifrmvp.selectdevice.brands.ui.BrandsScreen

class BrandsDecomposeComponentImpl(
    componentContext: ComponentContext,
    brandsComponentFactory: BrandsComponent.Factory,
    categoryId: Long,
    onBackClicked: () -> Unit,
    onBrandClicked: (BrandModel) -> Unit
) : BrandsDecomposeComponent, ComponentContext by componentContext {
    private val brandsComponent = brandsComponentFactory.createBrandsComponent(
        componentContext = childContext("BrandsComponent"),
        categoryId = categoryId,
        onBackClicked = onBackClicked,
        onBrandClicked = onBrandClicked
    )

    @Composable
    override fun Render() {
        BrandsScreen(brandsComponent = brandsComponent)
    }
}

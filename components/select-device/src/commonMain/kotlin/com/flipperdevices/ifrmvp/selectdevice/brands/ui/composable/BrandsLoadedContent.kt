package com.flipperdevices.ifrmvp.selectdevice.brands.ui.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.flipperdevices.ifrmvp.backend.model.BrandModel
import com.flipperdevices.ifrmvp.selectdevice.brands.presentation.decompose.BrandsComponent

@Composable
fun BrandsLoadedContent(
    model: BrandsComponent.Model.Loaded,
    onBrandClicked: (BrandModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    AlphabetSearch(
        model = model,
        modifier = modifier,
        onBrandClicked = onBrandClicked
    )
}

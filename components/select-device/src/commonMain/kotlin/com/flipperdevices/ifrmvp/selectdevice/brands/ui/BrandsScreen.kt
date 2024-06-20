package com.flipperdevices.ifrmvp.selectdevice.brands.ui

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.flipperdevices.ifrmvp.selectdevice.brands.presentation.BrandsComponent
import com.flipperdevices.ifrmvp.selectdevice.brands.ui.composable.BrandsLoadedContent
import com.flipperdevices.ifrmvp.selectdevice.categories.ui.components.ErrorComposable
import com.flipperdevices.ifrmvp.selectdevice.categories.ui.components.LoadingComposable
import com.flipperdevices.ifrmvp.selectdevice.categories.ui.components.SharedTopBar

@Composable
fun BrandsScreen(brandsComponent: BrandsComponent) {
    val model by brandsComponent.model.collectAsState()
    Scaffold(
        topBar = {
            SharedTopBar(
                title = "Select Brand",
                subtitle = "Add remote",
                onBackClicked = brandsComponent::onBackClicked
            )
        }
    ) { scaffoldPaddings ->
        Crossfade(model) { model ->
            when (model) {
                BrandsComponent.Model.Error -> {
                    ErrorComposable {
                        brandsComponent.tryLoad()
                    }
                }

                is BrandsComponent.Model.Loaded -> {
                    BrandsLoadedContent(
                        model = model,
                        modifier = Modifier.padding(scaffoldPaddings),
                        onBrandClicked = brandsComponent::onBrandClicked
                    )
                }

                BrandsComponent.Model.Loading -> {
                    LoadingComposable()
                }
            }
        }
    }
}

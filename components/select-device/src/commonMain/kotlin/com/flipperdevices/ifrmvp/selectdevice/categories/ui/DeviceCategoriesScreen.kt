package com.flipperdevices.ifrmvp.selectdevice.categories.ui

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.flipperdevices.core.ui.theme.LocalPalletV2
import com.flipperdevices.ifrmvp.backend.model.DeviceCategory
import com.flipperdevices.ifrmvp.components.select.device.RemoteSetupR
import com.flipperdevices.ifrmvp.selectdevice.categories.presentation.decompose.DeviceCategoriesComponent
import com.flipperdevices.ifrmvp.selectdevice.categories.ui.components.DeviceCategoryComposable
import com.flipperdevices.ifrmvp.selectdevice.categories.ui.components.ErrorComposable
import com.flipperdevices.ifrmvp.selectdevice.categories.ui.components.LoadingComposable
import com.flipperdevices.ifrmvp.selectdevice.categories.ui.components.SharedTopBar
import dev.icerock.moko.resources.compose.localized
import dev.icerock.moko.resources.desc.desc

@Composable
private fun LoadedContent(
    model: DeviceCategoriesComponent.Model.Loaded,
    onCategoryClicked: (DeviceCategory) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.padding(horizontal = 16.dp, vertical = 14.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(model.deviceTypes) { deviceCategory ->
            DeviceCategoryComposable(
                deviceCategory = deviceCategory,
                onClicked = {
                    onCategoryClicked.invoke(deviceCategory)
                }
            )
        }
    }
}

@Composable
fun DeviceCategoriesScreen(deviceCategoriesComponent: DeviceCategoriesComponent) {
    val model by deviceCategoriesComponent.model.collectAsState()
    Scaffold(
        topBar = {
            SharedTopBar(
                title = RemoteSetupR.strings.categories_title.desc().localized(),
                subtitle = RemoteSetupR.strings.categories_subtitle.desc().localized(),
                onBackClicked = deviceCategoriesComponent::onBackClicked
            )
        },
        backgroundColor = LocalPalletV2.current.surface.backgroundMain.body
    ) { scaffoldPaddings ->
        Crossfade(model) { model ->
            when (model) {
                DeviceCategoriesComponent.Model.Error -> {
                    ErrorComposable {
                        deviceCategoriesComponent.tryLoad()
                    }
                }

                is DeviceCategoriesComponent.Model.Loaded -> {
                    LoadedContent(
                        model = model,
                        modifier = Modifier.padding(scaffoldPaddings),
                        onCategoryClicked = deviceCategoriesComponent::onCategoryClicked
                    )
                }

                DeviceCategoriesComponent.Model.Loading -> {
                    LoadingComposable()
                }
            }
        }
    }
}

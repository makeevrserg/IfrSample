package com.flipperdevices.ifrmvp.selectdevice.setup.ui

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.flipperdevices.ifrmvp.components.select.device.RemoteSetupR
import com.flipperdevices.ifrmvp.selectdevice.categories.ui.components.ErrorComposable
import com.flipperdevices.ifrmvp.selectdevice.categories.ui.components.LoadingComposable
import com.flipperdevices.ifrmvp.selectdevice.categories.ui.components.SharedTopBar
import com.flipperdevices.ifrmvp.selectdevice.setup.presentation.decompose.SetupComponent
import com.flipperdevices.ifrmvp.selectdevice.setup.ui.components.LoadedContent
import dev.icerock.moko.resources.compose.localized
import dev.icerock.moko.resources.desc.desc

@Composable
fun SetupScreen(setupComponent: SetupComponent) {
    val model by setupComponent.model.collectAsState()
    Scaffold(
        topBar = {
            SharedTopBar(
                title = RemoteSetupR.strings.setup_title.desc().localized(),
                subtitle = RemoteSetupR.strings.setup_subtitle.desc().localized(),
                onBackClicked = setupComponent::onBackClicked
            )
        }
    ) { scaffoldPaddings ->
        Crossfade(model) { model ->
            when (model) {
                SetupComponent.Model.Error -> {
                    ErrorComposable {
                        setupComponent.onSuccessClicked()
                    }
                }

                is SetupComponent.Model.Loaded -> {
                    LoadedContent(
                        model = model,
                        modifier = Modifier.padding(scaffoldPaddings),
                        onPositiveClicked = setupComponent::onSuccessClicked,
                        onNegativeClicked = setupComponent::onFailedClicked,
                        onDispatchSignalClicked = setupComponent::dispatchSignal
                    )
                }

                SetupComponent.Model.Loading -> {
                    LoadingComposable()
                }
            }
        }
    }
}

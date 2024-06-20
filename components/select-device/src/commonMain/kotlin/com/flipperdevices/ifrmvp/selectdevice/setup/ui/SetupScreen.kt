package com.flipperdevices.ifrmvp.selectdevice.setup.ui

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.flipperdevices.ifrmvp.selectdevice.categories.ui.components.ErrorComposable
import com.flipperdevices.ifrmvp.selectdevice.categories.ui.components.LoadingComposable
import com.flipperdevices.ifrmvp.selectdevice.categories.ui.components.SharedTopBar
import com.flipperdevices.ifrmvp.selectdevice.setup.presentation.SetupComponent
import com.flipperdevices.ifrmvp.selectdevice.setup.ui.components.LoadedContent

@Composable
fun SetupScreen(setupComponent: SetupComponent) {
    val model by setupComponent.model.collectAsState()
    Scaffold(
        topBar = {
            SharedTopBar(
                title = "Set Up Remote",
                subtitle = "Add remote",
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
                        onNegativeClicked = setupComponent::onFailedClicked
                    )
                }

                SetupComponent.Model.Loading -> {
                    LoadingComposable()
                }
            }
        }
    }
}

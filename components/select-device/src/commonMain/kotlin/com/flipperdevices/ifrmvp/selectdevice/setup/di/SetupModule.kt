package com.flipperdevices.ifrmvp.selectdevice.setup.di

import com.arkivanov.decompose.ComponentContext
import com.flipperdevices.ifrmvp.api.backend.di.ApiBackendModule
import com.flipperdevices.ifrmvp.backend.model.IfrFileModel
import com.flipperdevices.ifrmvp.selectdevice.setup.presentation.decompose.SetupComponent
import com.flipperdevices.ifrmvp.selectdevice.setup.presentation.decompose.SetupDecomposeComponent
import com.flipperdevices.ifrmvp.selectdevice.setup.presentation.decompose.internal.DefaultSetupComponent
import com.flipperdevices.ifrmvp.selectdevice.setup.presentation.decompose.internal.SetupDecomposeComponentImpl
import com.flipperdevices.ifrmvp.selectdevice.setup.presentation.feature.CurrentSignalFeature
import com.flipperdevices.ifrmvp.selectdevice.setup.presentation.feature.HistoryFeature

interface SetupModule {
    val setupDecomposeComponentFactory: SetupDecomposeComponent.Factory

    class Default(apiBackendModule: ApiBackendModule) : SetupModule {
        private val setupComponentFactory = object : SetupComponent.Factory {
            override fun createSetupComponent(
                componentContext: ComponentContext,
                param: SetupComponent.Param,
                onBack: () -> Unit,
                onIfrFileFound: (IfrFileModel) -> Unit
            ): SetupComponent {
                return DefaultSetupComponent(
                    componentContext = componentContext,
                    param = param,
                    onBackClicked = onBack,
                    onIfrFileFound = onIfrFileFound,
                    createHistoryFeature = {
                        HistoryFeature()
                    },
                    createCurrentSignalFeature = {
                        CurrentSignalFeature(
                            param = param,
                            apiBackend = apiBackendModule.apiBackend
                        )
                    }
                )
            }
        }
        override val setupDecomposeComponentFactory = object : SetupDecomposeComponent.Factory {
            override fun createSetupComponent(
                componentContext: ComponentContext,
                param: SetupComponent.Param,
                onBack: () -> Unit,
                onIfrFileFound: (IfrFileModel) -> Unit
            ): SetupDecomposeComponent {
                return SetupDecomposeComponentImpl(
                    componentContext = componentContext,
                    setupComponentFactory = setupComponentFactory,
                    param = param,
                    onBack = onBack,
                    onIfrFileFound = onIfrFileFound
                )
            }
        }
    }
}

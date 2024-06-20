package com.flipperdevices.ifrmvp.selectdevice.setup.di

import com.arkivanov.decompose.ComponentContext
import com.flipperdevices.ifrmvp.api.backend.di.ApiBackendModule
import com.flipperdevices.ifrmvp.selectdevice.setup.presentation.DefaultSetupComponent
import com.flipperdevices.ifrmvp.selectdevice.setup.presentation.SetupComponent
import com.flipperdevices.ifrmvp.selectdevice.setup.presentation.features.CurrentSignalFeature
import com.flipperdevices.ifrmvp.selectdevice.setup.presentation.features.HistoryFeature

interface SetupModule {
    val setupComponentFactory: SetupComponent.Factory

    class Default(apiBackendModule: ApiBackendModule) : SetupModule {
        override val setupComponentFactory = object : SetupComponent.Factory {
            override fun createSetupComponent(
                componentContext: ComponentContext,
                param: SetupComponent.Param,
                onBack: () -> Unit
            ): SetupComponent {
                return DefaultSetupComponent(
                    componentContext = componentContext,
                    param = param,
                    onBackClicked = onBack,
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
    }
}

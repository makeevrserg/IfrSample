package com.flipperdevices.ifrmvp.selectdevice.root.presentation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.flipperdevices.ifrmvp.selectdevice.categories.di.DeviceCategoriesModule
import kotlinx.serialization.Serializable

internal class DefaultSelectDeviceRootComponent(
    componentContext: ComponentContext,
    deviceCategoriesModule: DeviceCategoriesModule
) : SelectDeviceRootComponent, ComponentContext by componentContext {
    private val navigation = StackNavigation<Configuration>()

    override val childStack: Value<ChildStack<*, SelectDeviceRootComponent.Child>> = childStack(
        source = navigation,
        initialConfiguration = Configuration.SelectCategory,
        handleBackButton = true,
        serializer = Configuration.serializer(),
        childFactory = { config, childContext ->
            when (config) {
                Configuration.SelectCategory -> {
                    val deviceCategoriesComponent = deviceCategoriesModule.createDeviceCategoriesComponent(
                        componentContext = childContext
                    )
                    SelectDeviceRootComponent.Child.SelectCategory(deviceCategoriesComponent)
                }
            }
        }
    )

    @Serializable
    private sealed interface Configuration {
        data object SelectCategory : Configuration
    }
}

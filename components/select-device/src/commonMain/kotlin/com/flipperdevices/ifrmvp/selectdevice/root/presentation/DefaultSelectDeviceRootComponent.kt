package com.flipperdevices.ifrmvp.selectdevice.root.presentation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.flipperdevices.ifrmvp.selectdevice.brands.di.BrandsModule
import com.flipperdevices.ifrmvp.selectdevice.categories.di.DeviceCategoriesModule
import com.flipperdevices.ifrmvp.selectdevice.setup.di.SetupModule
import com.flipperdevices.ifrmvp.selectdevice.setup.presentation.SetupComponent
import kotlinx.serialization.Serializable

internal class DefaultSelectDeviceRootComponent(
    componentContext: ComponentContext,
    deviceCategoriesModule: DeviceCategoriesModule,
    brandsModule: BrandsModule,
    setupModule: SetupModule,
    onBackClicked: () -> Unit
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
                    val deviceCategoriesComponent = deviceCategoriesModule
                        .deviceCategoriesFactory
                        .createDeviceCategoriesComponent(
                            componentContext = childContext,
                            onBackClicked = onBackClicked,
                            onCategoryClicked = { deviceCategory ->
                                val configuration = Configuration.Brands(deviceCategory.name)
                                navigation.push(configuration)
                            }
                        )
                    SelectDeviceRootComponent.Child.SelectCategory(deviceCategoriesComponent)
                }

                is Configuration.Brands -> {
                    val brandsComponent = brandsModule
                        .brandsComponentFactory
                        .createBrandsComponent(
                            componentContext = childContext,
                            onBackClicked = navigation::pop,
                            categoryName = config.categoryName,
                            onBrandClicked = {
                                val configuration = Configuration.Setup()
                                navigation.push(configuration)
                            }
                        )
                    SelectDeviceRootComponent.Child.Brands(brandsComponent)
                }

                is Configuration.Setup -> {
                    val setupComponent = setupModule
                        .setupComponentFactory
                        .createSetupComponent(
                            componentContext = childContext,
                            param = SetupComponent.Param(1, 2),
                            onBack = navigation::pop
                        )
                    SelectDeviceRootComponent.Child.Setup(setupComponent)
                }
            }
        }
    )

    @Serializable
    private sealed interface Configuration {
        @Serializable
        data object SelectCategory : Configuration

        @Serializable
        data class Brands(val categoryName: String) : Configuration

        @Serializable
        class Setup : Configuration
    }
}

package com.flipperdevices.ifrmvp.selectdevice.root.presentation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.flipperdevices.ifrmvp.backend.model.IfrFileModel
import com.flipperdevices.ifrmvp.selectdevice.brands.di.BrandsModule
import com.flipperdevices.ifrmvp.selectdevice.categories.di.DeviceCategoriesModule
import com.flipperdevices.ifrmvp.selectdevice.setup.di.SetupModule
import com.flipperdevices.ifrmvp.selectdevice.setup.presentation.decompose.SetupComponent
import kotlinx.serialization.Serializable

internal class DefaultSelectDeviceRootComponent(
    componentContext: ComponentContext,
    deviceCategoriesModule: DeviceCategoriesModule,
    brandsModule: BrandsModule,
    setupModule: SetupModule,
    onBackClicked: () -> Unit,
    onIfrFileFound: (IfrFileModel) -> Unit
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
                        .categoriesDecomposeComponentFactory
                        .create(
                            componentContext = childContext,
                            onBackClicked = onBackClicked,
                            onCategoryClicked = { deviceCategory ->
                                val configuration = Configuration.Brands(deviceCategory.id)
                                navigation.push(configuration)
                            }
                        )
                    SelectDeviceRootComponent.Child.SelectCategory(deviceCategoriesComponent)
                }

                is Configuration.Brands -> {
                    val brandsDecomposeComponent = brandsModule
                        .brandsDecomposeComponentFactory
                        .createBrandsComponent(
                            componentContext = childContext,
                            onBackClicked = navigation::pop,
                            categoryId = config.categoryId,
                            onBrandClicked = {
                                val configuration = Configuration.Setup(
                                    categoryId = it.categoryId,
                                    brandId = it.id
                                )
                                navigation.push(configuration)
                            }
                        )
                    SelectDeviceRootComponent.Child.Brands(brandsDecomposeComponent)
                }

                is Configuration.Setup -> {
                    val setupDecomposeComponent = setupModule
                        .setupDecomposeComponentFactory
                        .createSetupComponent(
                            componentContext = childContext,
                            param = SetupComponent.Param(
                                brandId = config.brandId,
                                categoryId = config.categoryId
                            ),
                            onBack = navigation::pop,
                            onIfrFileFound = onIfrFileFound
                        )
                    SelectDeviceRootComponent.Child.Setup(setupDecomposeComponent)
                }
            }
        }
    )

    @Serializable
    private sealed interface Configuration {
        @Serializable
        data object SelectCategory : Configuration

        @Serializable
        data class Brands(val categoryId: Long) : Configuration

        @Serializable
        class Setup(val categoryId: Long, val brandId: Long) : Configuration
    }
}

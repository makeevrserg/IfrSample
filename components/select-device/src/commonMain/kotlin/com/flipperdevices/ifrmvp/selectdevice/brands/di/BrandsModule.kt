package com.flipperdevices.ifrmvp.selectdevice.brands.di

import com.arkivanov.decompose.ComponentContext
import com.flipperdevices.ifrmvp.api.backend.di.ApiBackendModule
import com.flipperdevices.ifrmvp.backend.model.BrandModel
import com.flipperdevices.ifrmvp.selectdevice.brands.presentation.data.BackendBrandsRepository
import com.flipperdevices.ifrmvp.selectdevice.brands.presentation.decompose.BrandsComponent
import com.flipperdevices.ifrmvp.selectdevice.brands.presentation.decompose.BrandsDecomposeComponent
import com.flipperdevices.ifrmvp.selectdevice.brands.presentation.decompose.internal.BrandsDecomposeComponentImpl
import com.flipperdevices.ifrmvp.selectdevice.brands.presentation.decompose.internal.DefaultBrandsComponent
import com.flipperdevices.ifrmvp.selectdevice.brands.presentation.feature.BrandsListFeature
import com.flipperdevices.ifrmvp.selectdevice.brands.presentation.feature.QueryFeature
import ru.astrainteractive.klibs.mikro.core.dispatchers.DefaultKotlinDispatchers

interface BrandsModule {
    val brandsDecomposeComponentFactory: BrandsDecomposeComponent.Factory

    class Default(private val apiBackendModule: ApiBackendModule) : BrandsModule {
        private val brandsComponentFactory = object : BrandsComponent.Factory {
            override fun createBrandsComponent(
                componentContext: ComponentContext,
                categoryId: Long,
                onBackClicked: () -> Unit,
                onBrandClicked: (BrandModel) -> Unit
            ): BrandsComponent {
                return DefaultBrandsComponent(
                    componentContext = componentContext,
                    onBackClicked = onBackClicked,
                    createBrandsListFeature = {
                        BrandsListFeature(
                            categoryId = categoryId,
                            brandsRepository = BackendBrandsRepository(
                                apiBackend = apiBackendModule.apiBackend,
                                dispatchers = DefaultKotlinDispatchers
                            )
                        )
                    },
                    createQueryFeature = {
                        QueryFeature()
                    },
                    onBrandClicked = onBrandClicked
                )
            }
        }
        override val brandsDecomposeComponentFactory = object : BrandsDecomposeComponent.Factory {
            override fun createBrandsComponent(
                componentContext: ComponentContext,
                categoryId: Long,
                onBackClicked: () -> Unit,
                onBrandClicked: (BrandModel) -> Unit
            ): BrandsDecomposeComponent {
                return BrandsDecomposeComponentImpl(
                    componentContext = componentContext,
                    brandsComponentFactory = brandsComponentFactory,
                    categoryId = categoryId,
                    onBackClicked = onBackClicked,
                    onBrandClicked = onBrandClicked
                )
            }
        }
    }
}

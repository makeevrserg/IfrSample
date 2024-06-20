package com.flipperdevices.ifrmvp.selectdevice.brands.di

import com.arkivanov.decompose.ComponentContext
import com.flipperdevices.ifrmvp.api.backend.di.ApiBackendModule
import com.flipperdevices.ifrmvp.backend.model.BrandModel
import com.flipperdevices.ifrmvp.selectdevice.brands.presentation.BrandsComponent
import com.flipperdevices.ifrmvp.selectdevice.brands.presentation.DefaultBrandsComponent
import com.flipperdevices.ifrmvp.selectdevice.brands.presentation.data.BackendBrandsRepository
import com.flipperdevices.ifrmvp.selectdevice.brands.presentation.feature.BrandsListFeature
import com.flipperdevices.ifrmvp.selectdevice.brands.presentation.feature.QueryFeature
import ru.astrainteractive.klibs.mikro.core.dispatchers.DefaultKotlinDispatchers

interface BrandsModule {
    val brandsComponentFactory: BrandsComponent.Factory

    class Default(private val apiBackendModule: ApiBackendModule) : BrandsModule {
        override val brandsComponentFactory = object : BrandsComponent.Factory {
            override fun createBrandsComponent(
                componentContext: ComponentContext,
                categoryName: String,
                onBackClicked: () -> Unit,
                onBrandClicked: (BrandModel) -> Unit
            ): BrandsComponent {
                return DefaultBrandsComponent(
                    componentContext = componentContext,
                    onBackClicked = onBackClicked,
                    createBrandsListFeature = {
                        BrandsListFeature(
                            categoryName = categoryName,
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
    }
}

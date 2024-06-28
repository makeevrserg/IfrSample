package com.flipperdevices.ifrmvp.selectdevice.brands.presentation.decompose.internal

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.flipperdevices.ifrmvp.backend.model.BrandModel
import com.flipperdevices.ifrmvp.selectdevice.brands.presentation.decompose.BrandsComponent
import com.flipperdevices.ifrmvp.selectdevice.brands.presentation.feature.BrandsListFeature
import com.flipperdevices.ifrmvp.selectdevice.brands.presentation.feature.QueryFeature
import kotlinx.coroutines.flow.StateFlow
import ru.astrainteractive.klibs.mikro.core.util.combineStates

class DefaultBrandsComponent(
    componentContext: ComponentContext,
    private val onBackClicked: () -> Unit,
    private val onBrandClicked: (BrandModel) -> Unit,
    createBrandsListFeature: () -> BrandsListFeature,
    createQueryFeature: () -> QueryFeature
) : BrandsComponent, ComponentContext by componentContext {
    private val brandsListFeature = instanceKeeper.getOrCreate {
        createBrandsListFeature.invoke()
    }
    private val queryFeature = instanceKeeper.getOrCreate {
        createQueryFeature.invoke()
    }
    override val model: StateFlow<BrandsComponent.Model> = combineStates(
        flow1 = queryFeature.query,
        flow2 = brandsListFeature.state,
        transform = { query, pagingState ->
            when (pagingState) {
                is BrandsListFeature.State.Loading -> {
                    BrandsComponent.Model.Loading
                }

                is BrandsListFeature.State.Loaded -> {
                    BrandsComponent.Model.Loaded(
                        brands = pagingState.brands,
                        query = query
                    )
                }

                is BrandsListFeature.State.Error -> {
                    BrandsComponent.Model.Error
                }
            }
        }
    )

    override fun onBackClicked() {
        onBackClicked.invoke()
    }

    override fun onQueryChanged(query: String) {
        queryFeature.onQueryChanged(query)
    }

    override fun clearQuery() {
        queryFeature.clearQuery()
    }

    override fun onBrandClicked(brandModel: BrandModel) {
        onBrandClicked.invoke(brandModel)
    }

    override fun tryLoad() {
        brandsListFeature.tryLoad()
    }
}

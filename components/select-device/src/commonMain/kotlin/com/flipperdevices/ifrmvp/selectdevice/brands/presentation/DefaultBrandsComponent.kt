package com.flipperdevices.ifrmvp.selectdevice.brands.presentation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.flipperdevices.ifrmvp.selectdevice.brands.presentation.feature.BrandsListFeature
import kotlinx.coroutines.flow.StateFlow
import ru.astrainteractive.klibs.mikro.core.util.combineStates

class DefaultBrandsComponent(
    componentContext: ComponentContext,
    createBrandsListFeature: () -> BrandsListFeature
) : BrandsComponent, ComponentContext by componentContext {
    private val brandsListFeature = instanceKeeper.getOrCreate {
        createBrandsListFeature.invoke()
    }
    override val model: StateFlow<BrandsComponent.Model> = combineStates(
        flow1 = brandsListFeature.query,
        flow2 = brandsListFeature.pagingCollector.state,
        transform = { query, pagingState ->
            when {
                pagingState.items.isEmpty() && pagingState.isFailure -> {
                    BrandsComponent.Model.Error
                }

                pagingState.items.isEmpty() && pagingState.isLoading -> {
                    BrandsComponent.Model.Loading
                }

                else -> {
                    BrandsComponent.Model.Loaded(
                        brands = pagingState.items,
                        isNextPageLoading = pagingState.isLoading,
                        query = query
                    )
                }
            }
        }
    )

    override fun onQueryChanged(query: String) {
        brandsListFeature.onQueryChanged(query)
    }

    override fun clearQuery() {
        brandsListFeature.clearQuery()
    }
}

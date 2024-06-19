package com.flipperdevices.ifrmvp.selectdevice.brands.presentation

import com.flipperdevices.ifrmvp.backend.model.BrandModel
import kotlinx.coroutines.flow.StateFlow

interface BrandsComponent {
    val model: StateFlow<Model>

    fun onQueryChanged(query: String)

    fun clearQuery()

    sealed interface Model {
        data object Loading : Model
        data object Error : Model
        class Loaded(
            val brands: List<BrandModel>,
            val isNextPageLoading: Boolean,
            val query: String
        ) : Model
    }
}

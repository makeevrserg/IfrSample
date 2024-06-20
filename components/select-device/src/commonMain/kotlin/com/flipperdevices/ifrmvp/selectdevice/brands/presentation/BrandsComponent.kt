package com.flipperdevices.ifrmvp.selectdevice.brands.presentation

import com.arkivanov.decompose.ComponentContext
import com.flipperdevices.ifrmvp.backend.model.BrandModel
import kotlinx.coroutines.flow.StateFlow

interface BrandsComponent {
    val model: StateFlow<Model>

    fun onQueryChanged(query: String)

    fun clearQuery()

    fun onBackClicked()

    fun onBrandClicked(brandModel: BrandModel)

    fun tryLoad()

    sealed interface Model {
        data object Loading : Model
        data object Error : Model
        class Loaded(
            val brands: List<BrandModel>,
            val query: String
        ) : Model {
            val groupedBrands = brands.groupBy { brandModel ->
                brandModel.charSection()
            }.toList().sortedBy { it.first }

            val headers = groupedBrands.map { group -> group.first }
        }
    }

    interface Factory {
        fun createBrandsComponent(
            componentContext: ComponentContext,
            categoryName: String,
            onBackClicked: () -> Unit,
            onBrandClicked: (BrandModel) -> Unit
        ): BrandsComponent
    }

    companion object {
        fun BrandModel.charSection(): Char {
            val ch = name.first()
            return when {
                ch.isDigit() -> '#'
                ch.isLetter() -> ch.uppercaseChar()
                else -> '#'
            }
        }
    }
}

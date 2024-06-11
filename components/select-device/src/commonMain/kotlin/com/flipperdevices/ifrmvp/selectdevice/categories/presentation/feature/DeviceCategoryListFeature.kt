package com.flipperdevices.ifrmvp.selectdevice.categories.presentation.feature

import com.flipperdevices.ifrmvp.selectdevice.categories.presentation.DeviceCategoriesComponent
import com.flipperdevices.ifrmvp.selectdevice.categories.presentation.data.DeviceCategoriesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.astrainteractive.klibs.mikro.extensions.arkivanov.CoroutineFeature

internal class DeviceCategoryListFeature(
    private val deviceCategoriesRepository: DeviceCategoriesRepository
) : CoroutineFeature by CoroutineFeature.Main() {
    val model = MutableStateFlow<DeviceCategoriesComponent.Model>(DeviceCategoriesComponent.Model.Loading)

    private fun loadCategories() = launch {
        model.value = DeviceCategoriesComponent.Model.Loading
        deviceCategoriesRepository.fetchCategories()
            .onFailure { model.value = DeviceCategoriesComponent.Model.Error }
            .onSuccess { categories -> model.value = DeviceCategoriesComponent.Model.Loaded(categories) }
    }

    init {
        loadCategories()
    }
}

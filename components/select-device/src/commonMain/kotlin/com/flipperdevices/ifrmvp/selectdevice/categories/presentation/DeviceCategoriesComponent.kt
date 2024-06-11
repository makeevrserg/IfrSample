package com.flipperdevices.ifrmvp.selectdevice.categories.presentation

import com.flipperdevices.ifrmvp.backend.model.DeviceCategory
import kotlinx.coroutines.flow.StateFlow

interface DeviceCategoriesComponent {
    val model: StateFlow<Model>

    fun onCategoryClicked(category: DeviceCategory)

    fun onBackClicked()

    sealed interface Model {
        data object Loading : Model
        class Loaded(val deviceTypes: List<DeviceCategory>) : Model
        data object Error : Model
    }
}

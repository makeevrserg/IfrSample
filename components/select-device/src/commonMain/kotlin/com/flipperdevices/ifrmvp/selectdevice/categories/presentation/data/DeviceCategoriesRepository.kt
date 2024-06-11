package com.flipperdevices.ifrmvp.selectdevice.categories.presentation.data

import com.flipperdevices.ifrmvp.backend.model.DeviceCategory

internal interface DeviceCategoriesRepository {
    suspend fun fetchCategories(): Result<List<DeviceCategory>>
}

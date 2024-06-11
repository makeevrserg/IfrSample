package com.flipperdevices.ifrmvp.selectdevice.categories.presentation.data

import com.flipperdevices.ifrmvp.api.backend.ApiBackend
import com.flipperdevices.ifrmvp.backend.model.CategoriesRequestBody
import com.flipperdevices.ifrmvp.backend.model.DeviceCategory
import kotlinx.coroutines.withContext
import ru.astrainteractive.klibs.mikro.core.dispatchers.KotlinDispatchers

internal class BackendDeviceCategoriesRepository(
    private val apiBackend: ApiBackend,
    private val dispatchers: KotlinDispatchers
) : DeviceCategoriesRepository {

    override suspend fun fetchCategories(): Result<List<DeviceCategory>> = runCatching {
        withContext(dispatchers.IO) {
            apiBackend.getCategories(CategoriesRequestBody()).items
        }
    }.onFailure(Throwable::printStackTrace)
}

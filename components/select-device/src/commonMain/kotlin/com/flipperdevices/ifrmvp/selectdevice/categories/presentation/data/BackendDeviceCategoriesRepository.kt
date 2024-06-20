package com.flipperdevices.ifrmvp.selectdevice.categories.presentation.data

import com.flipperdevices.ifrmvp.api.backend.ApiBackend
import com.flipperdevices.ifrmvp.backend.model.DeviceCategory
import kotlinx.coroutines.withContext
import ru.astrainteractive.klibs.mikro.core.dispatchers.KotlinDispatchers
import kotlin.random.Random

internal class BackendDeviceCategoriesRepository(
    private val apiBackend: ApiBackend,
    private val dispatchers: KotlinDispatchers
) : DeviceCategoriesRepository {

    override suspend fun fetchCategories(): Result<List<DeviceCategory>> = runCatching {
        if (Random.nextBoolean()) error("Some random error")
        withContext(dispatchers.IO) {
            apiBackend.getCategories().categories
        }
    }.onFailure(Throwable::printStackTrace)
}

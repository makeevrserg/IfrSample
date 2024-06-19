package com.flipperdevices.ifrmvp.selectdevice.categories.presentation.data

import com.flipperdevices.ifrmvp.backend.model.DeviceCategory
import com.flipperdevices.ifrmvp.backend.model.DeviceCategoryType
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import ru.astrainteractive.klibs.mikro.core.dispatchers.KotlinDispatchers

internal class LocalDeviceCategoriesRepository(
    private val dispatchers: KotlinDispatchers
) : DeviceCategoriesRepository {
    override suspend fun fetchCategories(): Result<List<DeviceCategory>> = runCatching {
        withContext(dispatchers.IO) {
            delay(300L) // todo debug-only
            listOf(
                DeviceCategory(1, "TV", DeviceCategoryType.TV),
                DeviceCategory(2, "Air Conditioner", DeviceCategoryType.AIR_CONDITIONER),
                DeviceCategory(3, "Set-top Box", DeviceCategoryType.SET_TOP_BOX),
                DeviceCategory(4, "Camera", DeviceCategoryType.CAMERA),
                DeviceCategory(5, "Fan", DeviceCategoryType.FAN),
                DeviceCategory(6, "A/V Receiver", DeviceCategoryType.A_V_RECEIVER),
                DeviceCategory(7, "DVD Player", DeviceCategoryType.DVD_PLAYER),
                DeviceCategory(8, "Smart Box", DeviceCategoryType.SMART_BOX),
                DeviceCategory(9, "Projector", DeviceCategoryType.PROJECTOR),
            )
        }
    }.onFailure(Throwable::printStackTrace)
}

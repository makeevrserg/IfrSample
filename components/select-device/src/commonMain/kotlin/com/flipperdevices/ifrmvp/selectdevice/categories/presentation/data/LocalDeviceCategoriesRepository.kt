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
                DeviceCategory("TV", DeviceCategoryType.TV),
                DeviceCategory("Air Conditioner", DeviceCategoryType.AIR_CONDITIONER),
                DeviceCategory("Set-top Box", DeviceCategoryType.SET_TOP_BOX),
                DeviceCategory("Camera", DeviceCategoryType.CAMERA),
                DeviceCategory("Fan", DeviceCategoryType.FAN),
                DeviceCategory("A/V Receiver", DeviceCategoryType.A_V_RECEIVER),
                DeviceCategory("DVD Player", DeviceCategoryType.DVD_PLAYER),
                DeviceCategory("Smart Box", DeviceCategoryType.SMART_BOX),
                DeviceCategory("Projector", DeviceCategoryType.PROJECTOR),
            )
        }
    }.onFailure(Throwable::printStackTrace)
}

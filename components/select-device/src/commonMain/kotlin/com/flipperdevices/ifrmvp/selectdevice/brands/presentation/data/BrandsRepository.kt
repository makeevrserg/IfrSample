package com.flipperdevices.ifrmvp.selectdevice.brands.presentation.data

import com.flipperdevices.ifrmvp.api.backend.ApiBackend
import com.flipperdevices.ifrmvp.backend.model.BrandModel
import kotlinx.coroutines.withContext
import ru.astrainteractive.klibs.mikro.core.dispatchers.KotlinDispatchers
import kotlin.random.Random

interface BrandsRepository {
    suspend fun fetchBrands(categoryName: String): Result<List<BrandModel>>
}

class BackendBrandsRepository(
    private val apiBackend: ApiBackend,
    private val dispatchers: KotlinDispatchers
) : BrandsRepository {
    override suspend fun fetchBrands(
        categoryName: String
    ): Result<List<BrandModel>> = withContext(dispatchers.IO) {
        runCatching {
            if (Random.nextBoolean()) error("Some random error")
            apiBackend.getManufacturers(categoryName).brands
        }
    }
}

class LocalBrandsRepository : BrandsRepository {
    override suspend fun fetchBrands(categoryName: String): Result<List<BrandModel>> = runCatching {
        if (Random.nextBoolean()) error("Some random error")
        var i = 0L
        listOf(
            BrandModel(i++, "123TV"),
            BrandModel(i++, "1TV"),
            BrandModel(i++, "77"),
            BrandModel(i++, "LG"),
            BrandModel(i++, "Abex"),
            BrandModel(i++, "Acer"),
            BrandModel(i++, "ACL"),
            BrandModel(i++, "Across"),
            BrandModel(i++, "Acme"),
            BrandModel(i++, "Adc"),
            BrandModel(i++, "Advert"),
        )
    }
}

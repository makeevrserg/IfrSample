package com.flipperdevices.ifrmvp.grid.presentation.data

import com.flipperdevices.ifrmvp.files.FilesApiFactory
import com.flipperdevices.ifrmvp.grid.presentation.layout.kitchen.KitchenLayoutFactory
import com.flipperdevices.ifrmvp.model.PagesLayout
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Suppress("UnusedPrivateMember")
internal object InMemoryPagesRepository : PagesRepository {
    private val filesApi = FilesApiFactory.create()
    private val json = Json {
        prettyPrint = true
        encodeDefaults = true
    }
    private val factory = KitchenLayoutFactory

    override fun pagesFlow(): Flow<PagesLayout> = flow {
        val pagesLayout = factory.create()
        filesApi.recreateAndWrite("${factory.FILE_NAME}.json", json.encodeToString(pagesLayout))
        emit(pagesLayout)
    }
}

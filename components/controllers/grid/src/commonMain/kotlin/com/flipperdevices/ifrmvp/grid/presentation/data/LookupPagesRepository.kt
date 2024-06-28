package com.flipperdevices.ifrmvp.grid.presentation.data

import com.flipperdevices.ifrmvp.files.FilesApiFactory
import com.flipperdevices.ifrmvp.model.PagesLayout
import kotlinx.serialization.json.Json

internal object LookupPagesRepository : PagesRepository {
    private val filesApi = FilesApiFactory.create()
    private val json = Json {
        isLenient = true
        ignoreUnknownKeys = true
    }

    override suspend fun fetchPages(ifrFileId: Long, uiFileId: Long): Result<PagesLayout> {
        val content = filesApi.readFile("./test_layout.json")
        return kotlin.runCatching {
            json.decodeFromString<PagesLayout>(content)
        }
    }
}

package com.flipperdevices.ifrmvp.sample.presentation.data

import com.flipperdevices.ifrmvp.files.FilesApiFactory
import com.flipperdevices.ifrmvp.model.PagesLayout
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.isActive
import kotlinx.serialization.json.Json

object LookupPagesRepository : PagesRepository {
    private val filesApi = FilesApiFactory.create()
    private val json = Json {
        isLenient = true
        ignoreUnknownKeys = true
    }

    override fun pagesFlow(): Flow<PagesLayout> = flow {
        while (currentCoroutineContext().isActive) {
            val content = filesApi.readFile("./test_layout.json")
            val pagesLayout = kotlin.runCatching {
                json.decodeFromString<PagesLayout>(content)
            }.getOrDefault(PagesLayout(emptyList()))
            emit(pagesLayout)
            delay(500L)
        }
    }
}

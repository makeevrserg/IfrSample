package org.company.grid.ui.presentation.layout.data

import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.isActive
import kotlinx.serialization.json.Json
import org.company.grid.model.PagesLayout
import java.io.File

object LookupPagesRepository : PagesRepository {
    private val json = Json {
        isLenient = true
        ignoreUnknownKeys = true
    }

    override fun pagesFlow(): Flow<PagesLayout> = flow {
        while (currentCoroutineContext().isActive) {
            val file = File("./test_layout.json")
            val pagesLayout = kotlin.runCatching {
                json.decodeFromString<PagesLayout>(file.readText())
            }.getOrDefault(PagesLayout(emptyList()))
            emit(pagesLayout)
            delay(500L)
        }
    }
}
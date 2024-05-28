package org.company.grid.ui.presentation

import kotlinx.serialization.json.Json
import org.company.grid.model.PageLayout
import java.io.File
import org.company.grid.model.PagesLayout

class JsonGridLayoutFactory(private val file: File) {
    fun create(): PagesLayout {
        return json.decodeFromString(file.readText())
    }

    companion object {
        private val json = Json {
            isLenient = true
            ignoreUnknownKeys = true
        }
    }
}

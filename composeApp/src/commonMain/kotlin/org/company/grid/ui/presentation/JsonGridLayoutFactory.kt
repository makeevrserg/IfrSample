package org.company.grid.ui.presentation

import kotlinx.serialization.json.Json
import org.company.grid.model.GridLayout
import java.io.File

class JsonGridLayoutFactory(private val file: File) {
    fun create(): GridLayout {
        return json.decodeFromString(file.readText())
    }

    companion object {
        private val json = Json {
            isLenient = true
            ignoreUnknownKeys = true
        }
    }
}

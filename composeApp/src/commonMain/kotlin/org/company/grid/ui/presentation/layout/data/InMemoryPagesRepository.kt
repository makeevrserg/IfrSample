package org.company.grid.ui.presentation.layout.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.company.grid.model.PagesLayout
import org.company.grid.ui.presentation.layout.kitchen.KitchenLayoutFactory
import java.io.File
import org.company.grid.ui.presentation.layout.fan.FanLayoutFactory
import org.company.grid.ui.presentation.layout.fan.components.FanDisplayItemsFactory

object InMemoryPagesRepository : PagesRepository {
    private val json = Json {
        prettyPrint = true
        encodeDefaults = true
    }

    override fun pagesFlow(): Flow<PagesLayout> = flow {
        val pagesLayout = FanLayoutFactory.create()
        val file = File("./temp_json.json")
        if (!file.exists()) file.createNewFile()
        file.writeText(json.encodeToString(pagesLayout))
        emit(pagesLayout)
    }
}

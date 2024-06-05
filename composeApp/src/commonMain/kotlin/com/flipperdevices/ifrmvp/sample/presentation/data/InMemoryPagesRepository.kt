package com.flipperdevices.ifrmvp.sample.presentation.data

import com.flipperdevices.ifrmvp.model.PagesLayout
import com.flipperdevices.ifrmvp.sample.presentation.layout.kitchen.KitchenLayoutFactory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

object InMemoryPagesRepository : PagesRepository {
    private val json = Json {
        prettyPrint = true
        encodeDefaults = true
    }
    private val factory = KitchenLayoutFactory
//    private val factory = FanLayoutFactory

    override fun pagesFlow(): Flow<PagesLayout> = flow {
        val pagesLayout = factory.create()
        val file = File("./${factory::class.java.simpleName}.json")
        if (!file.exists()) file.createNewFile()
        file.writeText(json.encodeToString(pagesLayout))
        emit(pagesLayout)
    }
}

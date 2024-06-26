package com.flipperdevices.ifrmvp.parser

import com.flipperdevices.ifrmvp.backend.db.signal.di.SignalApiModule
import com.flipperdevices.ifrmvp.backend.envkonfig.EnvKonfig
import com.flipperdevices.ifrmvp.parser.di.ParserModule
import com.flipperdevices.ifrmvp.parser.util.ParserPathResolver
import kotlinx.coroutines.runBlocking

fun main() {
    val parserModule = ParserModule.Default(
        signalApiModule = SignalApiModule.Default(
            signalDbConnection = EnvKonfig.signalDatabaseConnection
        )
    )
    runBlocking {
        parserModule.fillerController.fillDatabase().join()
    }
}

/**
 * Fix directory structure
 */
fun mainUnused() {
    val categories = ParserPathResolver.irDbFolderFolder.resolve("categories")
    categories.listFiles().orEmpty().forEach { categoryFolder ->
        categoryFolder
            .listFiles()
            .orEmpty()
            .forEach { brandFolder ->
                brandFolder.listFiles()
                    .orEmpty()
                    .filter { it.extension == "ir" }
                    .forEach { brandFile ->
                        val controllerFolder = brandFolder.resolve(brandFile.nameWithoutExtension)
                        controllerFolder.mkdir()
                        brandFile.copyTo(controllerFolder.resolve(brandFile.name))
                        brandFile.delete()
                    }
            }
    }
}

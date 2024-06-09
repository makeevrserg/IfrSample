package com.flipperdevices.ifrmvp.files

import okio.FileSystem
import okio.Path.Companion.toOkioPath
import java.io.File

actual object FilesApiFactory {
    actual fun create(): FilesApi {
        return IoFilesApi(
            fileSystem = FileSystem.SYSTEM,
            folder = File("./").toOkioPath()
        )
    }
}

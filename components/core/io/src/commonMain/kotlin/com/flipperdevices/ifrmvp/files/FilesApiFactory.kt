package com.flipperdevices.ifrmvp.files

import okio.FileSystem
import okio.SYSTEM

object FilesApiFactory {
    fun create(): FilesApi {
        return IoFilesApi(
            fileSystem = FileSystem.SYSTEM,
            folder = FileSystem.SYSTEM_TEMPORARY_DIRECTORY
        )
    }
}

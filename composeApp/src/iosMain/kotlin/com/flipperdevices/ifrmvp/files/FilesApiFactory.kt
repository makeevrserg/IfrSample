package com.flipperdevices.ifrmvp.files

import okio.FileSystem

actual object FilesApiFactory {
    actual fun create(): FilesApi {
        return IoFilesApi(
            fileSystem = FileSystem.SYSTEM,
            folder =  FileSystem.SYSTEM_TEMPORARY_DIRECTORY
        )
    }
}

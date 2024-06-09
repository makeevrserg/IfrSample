package com.flipperdevices.ifrmvp.files

import okio.FileSystem
import okio.Path

class IoFilesApi(
    private val fileSystem: FileSystem,
    private val folder: Path
) : FilesApi {

    override fun recreateAndWrite(fileName: String, content: String) {
        val filePath = folder / fileName
        fileSystem.delete(filePath, false)
        fileSystem.write(filePath, true) {
            writeUtf8(content)
        }
    }

    override fun readFile(fileName: String): String {
        val filePath = folder / fileName
        return fileSystem.read(filePath) {
            this.readUtf8()
        }
    }
}

package com.flipperdevices.ifrmvp.files

interface FilesApi {
    fun recreateAndWrite(fileName: String, content: String)
    fun readFile(fileName: String): String
}

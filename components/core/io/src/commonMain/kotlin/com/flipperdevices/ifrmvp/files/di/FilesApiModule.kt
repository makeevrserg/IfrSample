package com.flipperdevices.ifrmvp.files.di

import com.flipperdevices.ifrmvp.files.FilesApi
import com.flipperdevices.ifrmvp.files.FilesApiFactory

interface FilesApiModule {
    val filesApi: FilesApi

    class Default : FilesApiModule {
        override val filesApi: FilesApi = FilesApiFactory.create()
    }
}

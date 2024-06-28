package com.flipperdevices.ifrmvp.grid.presentation.data

import com.flipperdevices.ifrmvp.model.PagesLayout

internal interface PagesRepository {
    suspend fun fetchPages(ifrFileId: Long, uiFileId: Long): Result<PagesLayout>
}

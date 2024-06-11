package com.flipperdevices.ifrmvp.grid.presentation.data

import com.flipperdevices.ifrmvp.model.PagesLayout
import kotlinx.coroutines.flow.Flow

internal interface PagesRepository {
    fun pagesFlow(): Flow<PagesLayout>
}

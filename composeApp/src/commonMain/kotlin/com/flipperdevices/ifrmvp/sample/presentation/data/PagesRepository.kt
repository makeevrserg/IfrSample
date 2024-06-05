package com.flipperdevices.ifrmvp.sample.presentation.data

import com.flipperdevices.ifrmvp.model.PagesLayout
import kotlinx.coroutines.flow.Flow

interface PagesRepository {
    fun pagesFlow(): Flow<PagesLayout>
}

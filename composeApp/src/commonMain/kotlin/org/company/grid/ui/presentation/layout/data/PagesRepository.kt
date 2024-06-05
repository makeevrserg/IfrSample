package org.company.grid.ui.presentation.layout.data

import kotlinx.coroutines.flow.Flow
import org.company.grid.model.PagesLayout

interface PagesRepository {
    fun pagesFlow(): Flow<PagesLayout>
}

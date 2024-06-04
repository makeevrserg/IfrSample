package org.company.grid.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class PagesLayout(
    @SerialName("pages")
    val pages: List<PageLayout>
)

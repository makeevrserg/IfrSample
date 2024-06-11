package com.flipperdevices.ifrmvp.grid.presentation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.flipperdevices.ifrmvp.grid.presentation.feature.GridFeature
import ru.astrainteractive.klibs.mikro.core.util.mapStateFlow

internal class DefaultGridComponent(
    componentContext: ComponentContext,
    createGridFeature: () -> GridFeature
) : GridComponent, ComponentContext by componentContext {
    private val gridFeature = instanceKeeper.getOrCreate {
        createGridFeature.invoke()
    }
    override val model = gridFeature.layout.mapStateFlow { pagesLayout ->
        GridComponent.Model(pagesLayout)
    }
}

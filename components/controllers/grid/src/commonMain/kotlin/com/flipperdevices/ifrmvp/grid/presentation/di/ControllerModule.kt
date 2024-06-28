package com.flipperdevices.ifrmvp.grid.presentation.di

import com.flipperdevices.ifrmvp.grid.presentation.data.InMemoryPagesRepository
import com.flipperdevices.ifrmvp.grid.presentation.decompose.GridComponent
import com.flipperdevices.ifrmvp.grid.presentation.decompose.internal.DefaultGridComponent
import com.flipperdevices.ifrmvp.grid.presentation.feature.GridFeature

interface ControllerModule {

    val gridComponentFactory: GridComponent.Factory

    class Default : ControllerModule {
        override val gridComponentFactory = GridComponent.Factory { componentContext, param ->
            DefaultGridComponent(
                componentContext = componentContext,
                param = param,
                createGridFeature = { param ->
                    GridFeature(
                        pagesRepository = InMemoryPagesRepository,
                        param = param
                    )
                }
            )
        }
    }
}

package com.flipperdevices.ifrmvp.grid.presentation.di

import com.arkivanov.decompose.ComponentContext
import com.flipperdevices.ifrmvp.grid.presentation.DefaultGridComponent
import com.flipperdevices.ifrmvp.grid.presentation.GridComponent
import com.flipperdevices.ifrmvp.grid.presentation.data.InMemoryPagesRepository
import com.flipperdevices.ifrmvp.grid.presentation.feature.GridFeature

interface ControllerModule {

    fun createGridComponent(componentContext: ComponentContext): GridComponent

    class Default : ControllerModule {
        override fun createGridComponent(componentContext: ComponentContext): GridComponent {
            return DefaultGridComponent(
                componentContext = componentContext,
                createGridFeature = {
                    GridFeature(
                        pagesRepository = InMemoryPagesRepository
                    )
                }
            )
        }
    }
}

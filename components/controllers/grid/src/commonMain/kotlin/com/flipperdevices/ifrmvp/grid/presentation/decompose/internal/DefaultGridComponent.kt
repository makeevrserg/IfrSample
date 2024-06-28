package com.flipperdevices.ifrmvp.grid.presentation.decompose.internal

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.flipperdevices.ifrmvp.grid.presentation.decompose.GridComponent
import com.flipperdevices.ifrmvp.grid.presentation.feature.GridFeature
import com.flipperdevices.ifrmvp.model.IfrKeyIdentifier
import kotlinx.coroutines.flow.asStateFlow

internal class DefaultGridComponent(
    componentContext: ComponentContext,
    param: GridComponent.Param,
    createGridFeature: (param: GridComponent.Param) -> GridFeature
) : GridComponent, ComponentContext by componentContext {
    private val gridFeature = instanceKeeper.getOrCreate {
        createGridFeature.invoke(param)
    }
    override val model = gridFeature.model.asStateFlow()

    override fun onButtonClicked(identifier: IfrKeyIdentifier) {
    }

    override fun tryLoad() = gridFeature.tryLoad()
}

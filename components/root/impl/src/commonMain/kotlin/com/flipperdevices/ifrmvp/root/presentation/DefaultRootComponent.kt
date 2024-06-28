package com.flipperdevices.ifrmvp.root.presentation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.decompose.value.Value
import com.flipperdevices.ifrmvp.grid.presentation.decompose.GridComponent
import com.flipperdevices.ifrmvp.grid.presentation.di.ControllerModule
import com.flipperdevices.ifrmvp.root.presentation.model.RootRoute
import com.flipperdevices.ifrmvp.selectdevice.root.di.SelectDeviceRootModule

internal class DefaultRootComponent(
    componentContext: ComponentContext,
    private val controllerModule: ControllerModule,
    private val selectDeviceRootModule: SelectDeviceRootModule
) : RootRouter,
    RootComponent,
    ComponentContext by componentContext {
    private val navigation = StackNavigation<RootRoute>()

    override val childStack: Value<ChildStack<RootRoute, RootComponent.RootChild>> = childStack(
        source = navigation,
        initialConfiguration = RootRoute.SelectDevice,
        handleBackButton = true,
        serializer = RootRoute.serializer(),
        childFactory = { config, childContext ->

            when (config) {
                is RootRoute.Controller -> RootComponent.RootChild.Controller(
                    gridComponent = controllerModule.gridComponentFactory
                        .create(
                            componentContext = childContext,
                            param = GridComponent.Param(
                                ifrFileId = config.ifrFileId,
                                uiFileId = config.uiFileId
                            )
                        )
                )

                RootRoute.SelectDevice -> RootComponent.RootChild.SelectDevice(
                    selectDeviceRootComponent = selectDeviceRootModule.createSelectDeviceRootComponent(
                        componentContext = childContext,
                        onBackClicked = navigation::pop
                    )
                )
            }
        }
    )

    override fun push(screen: RootRoute) {
        navigation.push(screen)
    }

    override fun replaceCurrent(screen: RootRoute) {
        navigation.replaceCurrent(screen)
    }

    override fun replaceAll(screen: RootRoute) {
        navigation.replaceAll(screen)
    }

    override fun pop() {
        navigation.pop()
    }
}

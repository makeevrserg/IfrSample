package com.flipperdevices.ifrmvp.root.presentation

import com.flipperdevices.ifrmvp.root.presentation.model.RootRoute

interface RootRouter {

    fun push(screen: RootRoute)
    fun replaceCurrent(screen: RootRoute)
    fun replaceAll(screen: RootRoute)
    fun pop()
}

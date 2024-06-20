@file:Suppress("Filename")

import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.flipperdevices.ifrmvp.root.di.RootModule
import com.flipperdevices.ifrmvp.root.ui.RootApplicationComposable
import platform.UIKit.UIViewController

fun getViewController(): UIViewController {
    val rootModule = RootModule.Default()
    val lifecycle = LifecycleRegistry()
    val rootComponentContext = DefaultComponentContext(lifecycle)
    val rootComponent = rootModule.createRootComponent(rootComponentContext)
    return ComposeUIViewController {
        RootApplicationComposable(rootComponent)
    }
}

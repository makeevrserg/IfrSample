@file:Suppress("Filename")

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.flipperdevices.ifrmvp.core.theme.AdaptThemeFade
import com.flipperdevices.ifrmvp.root.di.RootModule
import com.flipperdevices.ifrmvp.root.ui.RootApplicationComposable
import java.awt.Dimension

fun main() = application {
    val rootModule = RootModule.Default()
    val lifecycle = LifecycleRegistry()
    val rootComponentContext = DefaultComponentContext(lifecycle)
    val rootComponent = rootModule.createRootComponent(rootComponentContext)
    Window(
        title = "IFR Sample",
        state = rememberWindowState(width = 375.dp, height = 812.dp),
        onCloseRequest = ::exitApplication,
    ) {
        window.minimumSize = Dimension(20, 20)

        AdaptThemeFade {
            RootApplicationComposable(rootComponent)
        }
    }
}

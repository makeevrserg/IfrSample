@file:Suppress("Filename")

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.flipperdevices.ifrmvp.ApplicationComposable
import com.flipperdevices.ifrmvp.core.theme.AdaptThemeFade
import java.awt.Dimension

fun main() = application {
    Window(
        title = "IFR Sample",
        state = rememberWindowState(width = 375.dp, height = 812.dp),
        onCloseRequest = ::exitApplication,
    ) {
        window.minimumSize = Dimension(20, 20)

        AdaptThemeFade {
            ApplicationComposable()
        }
    }
}

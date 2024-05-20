import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import org.company.app.ComposeApplication
import org.company.app.theme.AdaptThemeFade
import java.awt.Dimension

fun main() = application {
    Window(
        title = "Multiplatform App",
        state = rememberWindowState(width = 375.dp, height = 812.dp),
        onCloseRequest = ::exitApplication,
    ) {
        window.minimumSize = Dimension(20, 20)
        AdaptThemeFade {
            ComposeApplication()
        }
    }
}

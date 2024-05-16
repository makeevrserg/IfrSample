import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import java.awt.Dimension
import org.company.app.ComposeApplication
import org.company.app.theme.AdaptThemeFade

fun main() = application {
    Window(
        title = "Multiplatform App",
        state = rememberWindowState(width = 400.dp, height = 720.dp),
        onCloseRequest = ::exitApplication,
    ) {
        window.minimumSize = Dimension(400, 720)
        AdaptThemeFade {
            ComposeApplication()
        }
    }
}
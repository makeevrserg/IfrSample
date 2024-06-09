import androidx.compose.ui.window.ComposeUIViewController
import com.flipperdevices.ifrmvp.ApplicationComposable
import com.flipperdevices.ifrmvp.core.theme.AdaptThemeFade
import platform.UIKit.UIViewController

fun getViewController(): UIViewController {
    return ComposeUIViewController {
        AdaptThemeFade {
            ApplicationComposable()
        }
    }
}

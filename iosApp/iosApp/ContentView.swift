import SwiftUI
import composeApp

struct ContentView: View {
    var body: some View {
        ComposeView()
    }
}

struct ComposeView: UIViewRepresentable {
    func makeUIView(context: Context) -> some UIView {
        Main_iosKt.getViewController().view
    }

    func updateUIView(_ uiView: UIViewType, context: Context) {}
}

#Preview {
    ContentView()
}

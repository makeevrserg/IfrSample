import SwiftUI
import composeApp

struct ContentView: View {
    enum Destination {
        case compose
        case swiftui
    }

    var body: some View {
        NavigationStack {
            Section(header: Text("Options")) {
                NavigationLink(value: Destination.compose) {
                    Text("Compose")
                }
                NavigationLink(value: Destination.swiftui) {
                    Text("SwiftUI")
                }
            }
            .navigationDestination(for: Destination.self) {
                switch $0 {
                case .compose: ComposeView()
                case .swiftui: Text("SwiftUI")
                }

            }
        }
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

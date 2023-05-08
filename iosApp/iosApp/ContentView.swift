import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject var viewmodel: IOSSpaceXViewModel
    init() {
        viewmodel = IOSSpaceXViewModel()
    }
	var body: some View {
        NavigationView {
            listView()
                .navigationBarTitle("SpaceX Launches")
            
        }
    }
    private func listView() -> AnyView {
        switch viewmodel.viewModel.uiState.value {
        case is SpaceXUiLoading:
            return AnyView(ProgressView())
        case is SpaceXUiSuccess:
            @State var success = viewmodel.viewModel.uiState.value as? SpaceXUiSuccess
            if let launch = success?.launch {
                return AnyView(List(launch, id: \.self) { rocket in
                    RocketLaunchView(rocketLaunch: rocket)
                })
            } else {
                return AnyView(HStack {
                    VStack(alignment: .leading, spacing: 10.0) {
                        Text("No Connection")
                        Button("Try Again") {
                            self.viewmodel.viewModel.fetchSpaceXLauncher()
                        }
                    }
                })
            }
        case is SpaceXUiError:
            return AnyView(Text("Error"))
        default:
            return AnyView(EmptyView())
        }
    }
}
struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}

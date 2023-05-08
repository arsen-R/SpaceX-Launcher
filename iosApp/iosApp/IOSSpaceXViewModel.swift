//
//  IOSSpaceXViewModel.swift
//  iosApp
//
//  Created by arsen on 5/7/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

class IOSSpaceXViewModel: ObservableObject {
    let viewModel: SpaceXViewModel
    
    @Published private var uitate: SpaceXUi = SpaceXUiLoading()
    
    init() {
        viewModel = SpaceXViewModel()
        viewModel.observerSpaceX { uiState in
            self.uitate = uiState
        }
    }
    
    deinit {
        viewModel.clear()
    }
}

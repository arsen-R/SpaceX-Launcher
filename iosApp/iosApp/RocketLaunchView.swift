//
//  RocketLaunchView.swift
//  iosApp
//
//  Created by arsen on 5/8/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct RocketLaunchView: View {
    var rocketLaunch: RocketLaunch
    var body: some View {
        HStack()  {
            VStack(alignment: .leading, spacing: 10.0) {
                Text("Launch name: \(rocketLaunch.missionName!)")
                Text(successLaunch).foregroundColor(successColor)
                Text("Launch year: \(rocketLaunch.launchYear!)")
                Text("Launch description: \(rocketLaunch.details ?? "This launch doesn\'t have any details.")")
            }
        }
    }
}

extension RocketLaunchView {
    private var successLaunch: String {
        if let isSuccess = rocketLaunch.launchSuccess {
            return isSuccess.boolValue ? "Successful" : "Unsuccessful"
        } else {
            return "No data"
        }
    }
    private var successColor: Color {
        if let isSuccess = rocketLaunch.launchSuccess {
            return isSuccess.boolValue ? Color.green : Color.red
        } else {
            return Color.gray
        }
    }
}

package com.example.spacex.android.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.spacex.domain.model.RocketLaunch

@Composable
fun RocketLauncherItem(
    modifier: Modifier = Modifier,
    launch: RocketLaunch
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp),
        backgroundColor = Color.White
    ) {
        Column(
            modifier = modifier.padding(5.dp)
        ) {
            Text(text = "Launch name: ${launch.missionName}")
            Text(
                text = if (launch.launchSuccess == true) "Successful" else "Unsuccessful",
                color = if (launch.launchSuccess == true) Color(0xFF0C921B) else Color.Red
            )
            Text(text = "Launch year: ${launch.launchYear}")
            Text(text = "Launch description: ${launch.details ?: "This launch doesn\'t have any details."}")
        }
    }
}

@Preview
@Composable
fun RocketLauncherItemPreview() {
    val launch = RocketLaunch(missionName = "Fallout 1", launchSuccess = true, launchYear = "2023")
    RocketLauncherItem(launch = launch)
}
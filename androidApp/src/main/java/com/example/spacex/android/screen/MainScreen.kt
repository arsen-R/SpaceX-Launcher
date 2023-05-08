package com.example.spacex.android.screen

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.*
import com.example.spacex.android.composable.ErrorMessage
import com.example.spacex.android.composable.LoadingProgressBar
import com.example.spacex.android.composable.RocketLauncherItem
import com.example.spacex.data.SpaceXService
import com.example.spacex.data.mapper.RocketMapper
import com.example.spacex.data.repository.SpaceXLauncherRepositoryImpl
import com.example.spacex.presentation.SpaceXUi
import com.example.spacex.presentation.SpaceXViewModel

@Composable
fun MainScreen(
    viewModel: SpaceXViewModel = viewModel()
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "SpaceX Launcher")
            })
        },
        content = {
            Box(modifier = Modifier.padding(it)) {
                when(uiState) {
                    is SpaceXUi.Loading-> {
                        LoadingProgressBar()
                        Log.d("Fetch Launch", "Loading")
                    }
                    is SpaceXUi.Success-> {
                        Log.d("Fetch Launch", "Success")
                        LazyColumn {
                            items(uiState.launch) { launch ->
                                RocketLauncherItem(launch = launch)
                            }
                        }
                    }
                    is SpaceXUi.Error -> {
                        Log.d("Fetch Launch", "Error:${uiState.error}")
                        ErrorMessage {
                            viewModel.fetchSpaceXLauncher()
                        }
                    }
                }
            }
        }
    )
}
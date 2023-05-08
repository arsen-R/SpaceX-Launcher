package com.example.spacex.presentation

import com.example.spacex.data.network.Result
import com.example.spacex.data.repository.SpaceXLauncherRepositoryImpl
import com.example.spacex.domain.model.RocketLaunch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class SpaceXViewModel : CommonViewModel() {
    private val repositoryImpl: SpaceXLauncherRepositoryImpl = SpaceXLauncherRepositoryImpl()
    private val _uiState = MutableStateFlow<SpaceXUi>(SpaceXUi.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        fetchSpaceXLauncher()
    }

    fun fetchSpaceXLauncher() {
        viewModelScope.launch {
            repositoryImpl.getLaunchers().collect {
                when(it) {
                    is Result.Loading -> {
                        _uiState.value = SpaceXUi.Loading
                    }
                    is Result.Success -> {
                        _uiState.value = SpaceXUi.Success(it.data)
                    }
                    is Result.Error -> {
                        _uiState.value = SpaceXUi.Error(it.throwable)
                    }
                }
            }
        }
    }

    fun observerSpaceX(onChange: (SpaceXUi) -> Unit) {
        uiState.onEach {
            onChange(it)
        }.launchIn(viewModelScope)
    }
}

sealed interface SpaceXUi {
    object Loading: SpaceXUi
    data class Success(val launch: List<RocketLaunch>): SpaceXUi
    data class Error(val error: Throwable): SpaceXUi
}
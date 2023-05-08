package com.example.spacex.presentation

import kotlinx.coroutines.CoroutineScope

expect abstract class CommonViewModel() {
    val viewModelScope: CoroutineScope

    protected open fun onCleared()
}
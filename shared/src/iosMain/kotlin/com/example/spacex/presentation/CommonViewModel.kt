package com.example.spacex.presentation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

actual abstract class CommonViewModel {
    actual val viewModelScope: CoroutineScope = MainScope()

    protected actual open fun onCleared() {

    }

    fun clear() {
        onCleared()
        viewModelScope.cancel()
    }
}
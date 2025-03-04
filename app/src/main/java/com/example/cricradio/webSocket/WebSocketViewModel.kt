package com.example.cricradio.webSocket

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.time.delay
import javax.inject.Inject

@HiltViewModel
class WebSocketViewModel @Inject constructor(private val webSocketManager: WebSocketManager) : ViewModel() {

    private val _socketState = MutableStateFlow("Disconnected")
    val socketState: StateFlow<String> = _socketState

    val messageFlow = webSocketManager.messageFlow
    init {
        viewModelScope.launch {
            webSocketManager.connectionStatus.collect { isConnected ->
                _socketState.value = if (isConnected) "Connected" else "Disconnected"
                Log.d("WebSocketViewModel", "Socket state updated: ${_socketState.value}")
            }
        }
    }
    fun connect() {
        viewModelScope.launch {
            Log.d("WebSocketViewModel", "Attempting to connect...")
            _socketState.value = "Connecting..."
            webSocketManager.connect()

            // Add a small delay to allow connection state to update
            delay(500)

            if (webSocketManager.isConnected()) {
                _socketState.value = "Connected"
            } else {
                _socketState.value = "Disconnected"
            }
        }
    }


    fun sendMessage(message: String) {
        viewModelScope.launch {
            webSocketManager.sendMessage(message)
        }
    }

    fun disconnect() {
        viewModelScope.launch {
            webSocketManager.disconnect()
            _socketState.value = "Disconnected"
        }
    }

    override fun onCleared() {
        super.onCleared()
        disconnect()
    }
}

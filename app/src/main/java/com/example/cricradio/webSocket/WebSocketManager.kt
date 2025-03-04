package com.example.cricradio.webSocket

import android.util.Log
import io.ktor.client.*
import io.ktor.client.plugins.websocket.*
import io.ktor.websocket.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.isActive
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Singleton
class WebSocketManager @Inject constructor(private val client: HttpClient) {

    private var session: DefaultClientWebSocketSession? = null
    private val _messageFlow = MutableSharedFlow<String>()
    val messageFlow = _messageFlow.asSharedFlow()
    private val _connectionStatus = MutableStateFlow(false)
    val connectionStatus: StateFlow<Boolean> = _connectionStatus

    suspend fun connect() {
        try {

            client.webSocket("wss://ws.postman-echo.com/raw") {
                session = this
                println("WebSocket Connected!")
                _connectionStatus.value = true

                try {
                    for (frame in incoming) {
                        frame as? Frame.Text ?: continue
                        println("Received: ${frame.readText()}")
                    }
                } catch (e: Exception) {
                    println(" Error reading WebSocket messages: ${e.localizedMessage}")
                }
            }
        } catch (e: Exception) {
            println(" WebSocket connection error: ${e.message}")
            _connectionStatus.value = false
            e.printStackTrace()
        }
    }


    fun isConnected(): Boolean {
        return session?.isActive == true
    }



    suspend fun sendMessage(message: String) {
        Log.d("WebSocketViewModel", "Sending message: $message")
        session?.send(Frame.Text(message))
    }

    suspend fun disconnect() {
        session?.close()
        session = null
        Log.d("WebSocketManager", "WebSocket Disconnected")
    }
}

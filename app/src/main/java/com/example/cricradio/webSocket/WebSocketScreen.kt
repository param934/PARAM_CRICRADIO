package com.example.cricradio.websocket

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cricradio.webSocket.WebSocketViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun WebSocketScreen(viewModel: WebSocketViewModel = hiltViewModel()) {
    var message by remember { mutableStateOf("") }
    val socketState by viewModel.socketState.collectAsState()
    val isConnected = socketState == "Connected"
    val receivedMessages = remember { mutableStateListOf<String>() }

    LaunchedEffect(Unit) {
        viewModel.messageFlow.collectLatest { receivedMessages.add(it) }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                if (socketState == "Connected") viewModel.disconnect()
                else viewModel.connect()
            }
        ) {
            Text(if (socketState == "Connected") "Disconnect" else "Connect")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Status Text
        Text(
            text = "Status: $socketState",
            color = if (isConnected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Message Input and Send Button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = message,
                onValueChange = { message = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text(text = "Type your message") }
            )
            IconButton(onClick = {
                if (isConnected) {
                    viewModel.sendMessage(message)
                    message = ""
                }
            }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Send,
                    contentDescription = "Send",
                    tint = if (isConnected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display Received Messages
        Text(text = "Responses:", style = MaterialTheme.typography.titleMedium)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            receivedMessages.forEach { msg ->
                Text("📩 $msg", style = MaterialTheme.typography.bodyLarge,color= MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}

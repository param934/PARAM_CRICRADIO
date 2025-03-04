package com.example.cricradio.di

import com.example.cricradio.api.CricApiService
import com.example.cricradio.api.CricRepository
import com.example.cricradio.webSocket.WebSocketManager
import com.google.android.datatransport.runtime.logging.Logging
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.engine.cio.CIO
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClient(OkHttp) {  // ✅ Use CIO Engine instead of OkHttp
            install(WebSockets)  // ✅ Ensure WebSockets are installed
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
        }
    }

    @Provides
    @Singleton
    fun provideCricApiService(client: HttpClient): CricApiService {
        return CricApiService(client)
    }

    @Provides
    @Singleton
    fun provideCricRepository(apiService: CricApiService): CricRepository {
        return CricRepository(apiService)
    }

    @Provides
    @Singleton
    fun provideWebSocketManager(client: HttpClient): WebSocketManager {
        return WebSocketManager(client)
    }
}

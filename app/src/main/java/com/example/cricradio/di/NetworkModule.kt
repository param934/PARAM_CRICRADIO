package com.example.cricradio.di

import com.example.cricradio.api.CricApiService
import com.example.cricradio.api.CricRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClient(Android) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    coerceInputValues = true})
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
}

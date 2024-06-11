package com.flipperdevices.ifrmvp.api.backend.di

import com.flipperdevices.ifrmvp.api.backend.ApiBackend
import com.flipperdevices.ifrmvp.api.backend.ApiBackendImpl
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

interface ApiBackendModule {
    val json: Json
    val httpClient: HttpClient
    val apiBackend: ApiBackend

    class Default : ApiBackendModule {
        override val json: Json by lazy {
            Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            }
        }
        override val httpClient: HttpClient by lazy {
            HttpClient {
                install(ContentNegotiation) {
                    json(json)
                }
                install(Logging) {
                    logger = Logger.DEFAULT
                    level = LogLevel.HEADERS
                }
            }
        }
        override val apiBackend: ApiBackend by lazy {
            ApiBackendImpl(
                httpClient = httpClient,
                backendUrlHost = "127.0.0.1:8080",

            )
        }
    }
}

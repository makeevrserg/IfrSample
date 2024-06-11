package com.flipperdevices.ifrmvp.api.backend

import com.flipperdevices.ifrmvp.backend.model.CategoriesRequestBody
import com.flipperdevices.ifrmvp.backend.model.DeviceCategory
import com.flipperdevices.ifrmvp.backend.model.PagedModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.path
import kotlinx.serialization.json.Json

interface ApiBackend {
    suspend fun getCategories(request: CategoriesRequestBody): PagedModel<DeviceCategory>
}

internal class ApiBackendImpl(
    private val httpClient: HttpClient,
    private val backendUrlHost: String
) : ApiBackend {
    override suspend fun getCategories(request: CategoriesRequestBody): PagedModel<DeviceCategory> {
        return httpClient.post {
            url {
                host = backendUrlHost
                path("categories")
            }
            println("URL: $url")
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }
}

package ru.ivan.kmmproj.features.hubble.ktordatasource

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import ru.ivan.kmmproj.features.hubble.HubbleRemoteDataSource
import ru.ivan.kmmproj.features.hubble.models.KtorHubbleItem
import kotlin.collections.get

class KtorHubbleDataSource(
    private val httpClient: HttpClient,
    val json: Json
) : HubbleRemoteDataSource {

    override suspend fun fetchNews(): List<KtorHubbleItem> {
        val httpRequest = httpClient.get<HttpStatement> {
            url {
                path("/api/v3/news")
            }
        }

        return json.decodeFromString(
                ListSerializer(KtorHubbleItem.serializer()),
                httpRequest.execute().readText()
        )

    }
}
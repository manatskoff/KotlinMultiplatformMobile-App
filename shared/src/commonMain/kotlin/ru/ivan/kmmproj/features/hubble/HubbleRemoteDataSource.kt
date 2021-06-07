package ru.ivan.kmmproj.features.hubble

import ru.ivan.kmmproj.features.hubble.models.KtorHubbleItem


interface HubbleRemoteDataSource {
    suspend fun fetchNews(): List<KtorHubbleItem>
}
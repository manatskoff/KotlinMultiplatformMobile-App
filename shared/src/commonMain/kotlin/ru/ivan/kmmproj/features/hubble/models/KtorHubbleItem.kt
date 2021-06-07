package ru.ivan.kmmproj.features.hubble.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KtorHubbleItem (
        @SerialName("news_id") val newsId: String,
        @SerialName("name") val newsName: String
)
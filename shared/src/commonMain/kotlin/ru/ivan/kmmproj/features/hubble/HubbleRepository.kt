package ru.ivan.kmmproj.features.hubble


class HubbleRepository(
    private val remoteDataSource: HubbleRemoteDataSource
) {
    suspend fun fetchNews() = remoteDataSource.fetchNews()
}
package me.alberto.a3line.mockdata

import me.alberto.a3line.data.remote.model.UsersResponse
import me.alberto.a3line.data.remote.source.IRemoteSource

class FakeRemoteSource : IRemoteSource {
    override suspend fun getUsers(): UsersResponse {
        return remoteResponse
    }
}
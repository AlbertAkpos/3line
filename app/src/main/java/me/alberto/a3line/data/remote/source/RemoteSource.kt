package me.alberto.a3line.data.remote.source

import me.alberto.a3line.data.remote.model.UsersResponse
import me.alberto.a3line.data.remote.restclient.RemoteClient
import javax.inject.Inject

class RemoteSource @Inject constructor(private val restClient: RemoteClient) : IRemoteSource {
    override suspend fun getUsers(): UsersResponse {
        return restClient.getRemote().getUsers()
    }
}
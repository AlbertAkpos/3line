package me.alberto.a3line.data.remote.source

import me.alberto.a3line.data.remote.model.UsersResponse

interface IRemoteSource {
    suspend fun getUsers(): UsersResponse
}
package me.alberto.a3line.data.remote.restclient

import me.alberto.a3line.data.remote.model.UsersResponse
import me.alberto.a3line.util.Url
import retrofit2.http.GET

interface ApiService {
    @GET(Url.USERS)
    suspend fun getUsers(): UsersResponse
}
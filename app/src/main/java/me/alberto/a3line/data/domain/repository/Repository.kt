package me.alberto.a3line.data.domain.repository

import androidx.lifecycle.LiveData
import me.alberto.a3line.data.domain.model.User
import me.alberto.a3line.data.remote.source.IRemoteSource
import me.alberto.a3line.data.remote.toDomain
import javax.inject.Inject

class Repository @Inject constructor(private val remoteSource: IRemoteSource) : IRepository {
    override suspend fun getRemote(): List<User> {
        return remoteSource.getUsers().map { it.toDomain() }
    }

    override suspend fun addUser(vararg user: User) {
        TODO("Not yet implemented")
    }

    override suspend fun updateUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun getUsers(): LiveData<List<User>> {
        TODO("Not yet implemented")
    }
}
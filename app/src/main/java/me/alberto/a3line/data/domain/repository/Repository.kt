package me.alberto.a3line.data.domain.repository

import android.util.Log
import androidx.lifecycle.LiveData
import me.alberto.a3line.data.domain.model.User
import me.alberto.a3line.data.local.database.UserEntity
import me.alberto.a3line.data.local.source.ILocalSource
import me.alberto.a3line.data.mapper.toEntity
import me.alberto.a3line.data.remote.source.IRemoteSource
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteSource: IRemoteSource,
    private val localSource: ILocalSource
) : IRepository {
    override suspend fun getRemote() {
        val response = remoteSource.getUsers().map { it.toEntity() }
        Log.d("repository", "${response.size}")
        localSource.addUser(*response.toTypedArray())
    }

    override suspend fun addUser(vararg user: User) {
        val users = user.map { it.toEntity() }
        localSource.addUser(*users.toTypedArray())
    }

    override suspend fun updateUser(user: User) {
        localSource.updateUser(user.toEntity())
    }

    override fun getUsers(): LiveData<List<UserEntity>> {
        return localSource.getUsers()
    }
}
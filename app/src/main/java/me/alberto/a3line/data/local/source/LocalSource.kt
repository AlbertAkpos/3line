package me.alberto.a3line.data.local.source

import androidx.lifecycle.LiveData
import me.alberto.a3line.data.domain.model.User
import me.alberto.a3line.data.local.database.UserDatabase
import me.alberto.a3line.data.local.database.UserEntity
import me.alberto.a3line.data.mapper.toEntity
import me.alberto.a3line.data.remote.model.UserDTO
import javax.inject.Inject

class LocalSource @Inject constructor(private val database: UserDatabase) : ILocalSource {
    override suspend fun addUser(vararg user: User) {
        val list = user.map { it.toEntity() }
        database.userDao.addUser(*list.toTypedArray())
    }

    override suspend fun updateUser(user: UserEntity) {
        database.userDao.updateUser(user)
    }

    override fun getUsers(): LiveData<List<UserEntity>> {
        return database.userDao.getUsers()
    }

    override suspend fun addAll(users: List<UserDTO>) {
        val list  = users.map { it.toEntity() }
        database.userDao.addUser(*list.toTypedArray())
    }
}
package me.alberto.a3line.data.local.source

import androidx.lifecycle.LiveData
import me.alberto.a3line.data.local.database.UserDatabase
import me.alberto.a3line.data.local.database.UserEntity
import javax.inject.Inject

class LocalSource @Inject constructor(private val database: UserDatabase) : ILocalSource {
    override suspend fun addUser(vararg user: UserEntity) {
        database.userDao.addUser(*user)
    }

    override suspend fun updateUser(user: UserEntity) {
        database.userDao.updateUser(user)
    }

    override fun getUsers(): LiveData<List<UserEntity>> {
        return database.userDao.getUsers()
    }
}
package me.alberto.a3line.mockdata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import me.alberto.a3line.data.domain.model.User
import me.alberto.a3line.data.local.database.UserEntity
import me.alberto.a3line.data.local.source.ILocalSource
import me.alberto.a3line.data.mapper.toEntity
import me.alberto.a3line.data.remote.model.UserDTO
import me.alberto.a3line.util.entity
import me.alberto.a3line.util.updateUser

class FakeLocalSource(private val database: ArrayList<UserEntity>) : ILocalSource {
    override suspend fun addUser(vararg user: User) {
        val users = user.map { it.toEntity() }
        database.addAll(users)
    }

    override suspend fun updateUser(user: UserEntity) {
        database.updateUser(user)
    }

    override fun getUsers(): LiveData<List<UserEntity>> {
        return MutableLiveData(database)
    }

    override suspend fun addAll(users: List<UserDTO>) {
        val list = users.map { it.entity() }
        database.addAll(list)
    }
}
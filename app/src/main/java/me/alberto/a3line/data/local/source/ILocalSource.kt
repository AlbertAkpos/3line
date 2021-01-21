package me.alberto.a3line.data.local.source

import androidx.lifecycle.LiveData
import me.alberto.a3line.data.domain.model.User
import me.alberto.a3line.data.local.database.UserEntity
import me.alberto.a3line.data.remote.model.UserDTO

interface ILocalSource {
    suspend fun addUser(vararg user: User)
    suspend fun addAll(users: List<UserDTO>)
    suspend fun updateUser(user: UserEntity)
    fun getUsers(): LiveData<List<UserEntity>>

}
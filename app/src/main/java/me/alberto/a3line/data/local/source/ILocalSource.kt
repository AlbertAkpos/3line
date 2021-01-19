package me.alberto.a3line.data.local.source

import androidx.lifecycle.LiveData
import me.alberto.a3line.data.local.database.UserEntity

interface ILocalSource {
    suspend fun addUser(vararg user: UserEntity)
    suspend fun updateUser(user: UserEntity)
    fun getUsers(): LiveData<List<UserEntity>>
}
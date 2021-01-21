package me.alberto.a3line.data.domain.repository

import androidx.lifecycle.LiveData
import me.alberto.a3line.data.domain.model.User
import me.alberto.a3line.data.local.database.UserEntity

interface IRepository {
    suspend fun getRemote()
    suspend fun addUser(vararg user: User)
    suspend fun updateUser(user: User)
    fun getUsers(): LiveData<List<UserEntity>>

}
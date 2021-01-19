package me.alberto.a3line.data.domain.repository

import androidx.lifecycle.LiveData
import me.alberto.a3line.data.domain.model.User

interface IRepository {
    suspend fun getRemote(): List<User>
    suspend fun addUser(vararg user: User)
    suspend fun updateUser(user: User)
    fun getUsers(): LiveData<List<User>>

}
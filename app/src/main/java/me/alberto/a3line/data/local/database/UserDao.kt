package me.alberto.a3line.data.local.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM USER_TABLE")
    fun getUsers(): LiveData<List<UserEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(vararg userEntity: UserEntity)

    @Update
    suspend fun updateUser(vararg userEntity: UserEntity)
}
package me.alberto.a3line.data.local.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM USER_TABLE")
    fun getUsers(): LiveData<List<UserEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(vararg userEntity: UserEntity)

    @Update
    fun updateUser(vararg userEntity: UserEntity)
}
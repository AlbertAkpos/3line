package me.alberto.a3line.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [UserEntity::class], version = 1)
@TypeConverters(Converter::class)
abstract class UserDatabase : RoomDatabase() {
    abstract val userDao: UserDao

    companion object {
        private const val DATABASE = "user_database"
        private lateinit var INSTANCE: UserDatabase
        fun getDatabase(context: Context): UserDatabase {
            synchronized(UserDatabase::class) {
                if (!::INSTANCE.isInitialized) {
                    INSTANCE =
                        Room.databaseBuilder(context, UserDatabase::class.java, DATABASE).build()
                }
            }
            return INSTANCE
        }
    }
}
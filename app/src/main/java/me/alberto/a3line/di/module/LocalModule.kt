package me.alberto.a3line.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import me.alberto.a3line.data.local.database.UserDatabase
import javax.inject.Singleton

@Module
class LocalModule {
    @Provides
    @Singleton
    fun provideDatabase(context: Context): UserDatabase {
        return UserDatabase.getDatabase(context)
    }
}
package me.alberto.a3line.di.module

import dagger.Binds
import dagger.Module
import me.alberto.a3line.data.domain.repository.IRepository
import me.alberto.a3line.data.domain.repository.Repository
import me.alberto.a3line.data.local.source.ILocalSource
import me.alberto.a3line.data.local.source.LocalSource
import me.alberto.a3line.data.remote.source.IRemoteSource
import me.alberto.a3line.data.remote.source.RemoteSource

@Module
abstract class DataModule {
    @Binds
    abstract fun bindsRemoteSource(remoteSource: RemoteSource): IRemoteSource

    @Binds
    abstract fun bindsLocalSource(localSource: LocalSource): ILocalSource

    @Binds
    abstract fun bindsRepository(repository: Repository): IRepository
}
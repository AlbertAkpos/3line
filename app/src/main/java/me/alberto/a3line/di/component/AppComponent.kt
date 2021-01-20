package me.alberto.a3line.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import me.alberto.a3line.di.module.DataModule
import me.alberto.a3line.di.module.LocalModule
import me.alberto.a3line.di.module.ViewModelModule
import me.alberto.a3line.screens.details.view.DetailsActivity
import me.alberto.a3line.screens.home.view.HomeActivity
import javax.inject.Singleton

@Component(modules = [DataModule::class, LocalModule::class, ViewModelModule::class])
@Singleton
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: HomeActivity)
    fun inject(activity: DetailsActivity)
}
package me.alberto.a3line

import android.app.Application
import me.alberto.a3line.di.component.AppComponent
import me.alberto.a3line.di.component.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
    }
}
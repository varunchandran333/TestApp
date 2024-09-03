package com.training.testapp

import android.app.Application
import com.training.testapp.di.databaseModule
import com.training.testapp.di.networkModule
import com.training.testapp.di.repositoryModule
import com.training.testapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            androidLogger()
            modules(networkModule, databaseModule, repositoryModule, viewModelModule)
        }
    }
}
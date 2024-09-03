package com.training.testapp.di

import com.training.testapp.repository.DataSource
import com.training.testapp.repository.RepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    factory { RepositoryImpl(get()) }
    factory { DataSource(androidContext(), get()) }
}
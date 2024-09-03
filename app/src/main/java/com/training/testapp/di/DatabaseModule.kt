package com.training.testapp.di

import android.app.Application
import androidx.room.Room
import com.training.testapp.data.local.db.UserDataBase
import com.training.testapp.data.local.db.UserDao
import org.koin.dsl.module

fun provideDatabase(application: Application):UserDataBase = Room.databaseBuilder(
    application,
    UserDataBase::class.java,
    "user_table"
)
    .fallbackToDestructiveMigration()
    .build()

fun provideDao(userDataBase: UserDataBase): UserDao = userDataBase.getUserDao()


val databaseModule = module {
    single { provideDatabase(get()) }
    single { provideDao(get()) }
}
package com.training.testapp.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.training.testapp.data.model.User

@Database(entities = [(User::class)], version = 1)
abstract class UserDataBase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
}
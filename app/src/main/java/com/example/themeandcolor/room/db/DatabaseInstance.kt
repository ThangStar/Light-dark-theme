package com.example.themeandcolor.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.themeandcolor.room.column.User
import com.example.themeandcolor.room.dao.DAOUser

@Database(entities = [User::class], version = 2)
abstract class DataBaseInstance : RoomDatabase() {
    abstract fun userDao(): DAOUser
}

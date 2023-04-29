package com.example.themeandcolor.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.themeandcolor.room.column.User

@Dao
interface DAOUser {
    @Insert
    fun addUser(vararg user: User)

    @Query("SELECT * FROM User")
    suspend fun getAllUser(): List<User>
}
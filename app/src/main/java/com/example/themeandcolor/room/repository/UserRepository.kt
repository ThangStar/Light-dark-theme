package com.example.themeandcolor.room.repository

import com.example.themeandcolor.room.column.User
import com.example.themeandcolor.room.dao.DAOUser
import javax.inject.Inject

class UserRepository @Inject constructor(val daoUser: DAOUser) {
    suspend fun getAll() = daoUser.getAllUser()
    suspend fun insert(user: User) = daoUser.addUser(user)
}
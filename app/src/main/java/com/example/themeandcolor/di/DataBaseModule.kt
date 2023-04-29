package com.example.themeandcolor.di

import android.content.Context
import androidx.room.Room
import com.example.themeandcolor.room.dao.DAOUser
import com.example.themeandcolor.room.db.DataBaseInstance
import com.example.themeandcolor.room.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Singleton
    @Provides
    fun getDaoUser(db: DataBaseInstance): DAOUser {
        return db.userDao()
    }

    @Singleton
    @Provides
    fun getDataBase(@ApplicationContext context: Context): DataBaseInstance {
        return Room.databaseBuilder(context, DataBaseInstance::class.java, "dbUser").fallbackToDestructiveMigration().build()
    }
}

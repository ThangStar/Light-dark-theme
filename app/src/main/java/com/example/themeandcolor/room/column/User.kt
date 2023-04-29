package com.example.themeandcolor.room.column

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val uid: Int? = null,
    @ColumnInfo val fullname: String,
    @ColumnInfo val age: Int,
    @ColumnInfo val height: Float
)
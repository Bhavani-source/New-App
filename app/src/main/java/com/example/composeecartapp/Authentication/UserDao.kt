package com.example.composeecartapp.Authentication

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.TypeConverters

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM users WHERE username = :userName LIMIT 1")
    suspend fun getUserByUserName(userName : String) : User?

    @Query("SELECT COUNT(*) FROM users WHERE username = :userName")
    suspend fun checkUserExists(userName: String) :Int
}
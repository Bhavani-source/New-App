package com.example.composeecartapp.Authentication

import androidx.room.Index
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDao: UserDao) {
    suspend fun insertUser(user : User){
        userDao.insertUser(user)
    }

    suspend fun getUserByUsername(username : String) : User?{

        return userDao.getUserByUserName(username)
    }

    suspend fun checkUserExist(username: String) : Boolean{
        return userDao.checkUserExists(username) > 0
    }
}
package com.example.composeecartapp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.composeecartapp.Authentication.User
import com.example.composeecartapp.Authentication.UserDao
import com.example.composeecartapp.Products.Product
import com.example.composeecartapp.Products.ProductDao

@Database(entities = [User::class, Product::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao() : UserDao
    abstract fun productDao(): ProductDao

}
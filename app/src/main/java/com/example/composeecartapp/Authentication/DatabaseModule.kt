package com.example.composeecartapp.Authentication

import android.content.Context
import androidx.room.Room
import com.example.composeecartapp.AppDatabase
import com.example.composeecartapp.Products.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
fun provideRoomDataBase(@ApplicationContext context: Context) : AppDatabase{

    return Room.databaseBuilder(context,AppDatabase::class.java, "ecart_db").build()
}
@Provides
@Singleton
    fun provideUserDao(database: AppDatabase) : UserDao{
        return database.userDao()
    }

    @Provides
    @Singleton
    fun provideProductDao(database: AppDatabase): ProductDao {
        return database.productDao()
    }
}
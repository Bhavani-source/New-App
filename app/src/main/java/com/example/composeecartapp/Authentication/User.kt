package com.example.composeecartapp.Authentication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val id :Int = 0,
  @ColumnInfo(name = "UserName")  val userName :String,
   @ColumnInfo(name = "Password") val password : String
)

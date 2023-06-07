package com.app.roomdatabasecreadopertion.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.roomdatabasecreadopertion.dao.UserDao
import com.app.roomdatabasecreadopertion.model.UserData

@Database(entities = [UserData::class], version = 1)
abstract class Appdatabase:RoomDatabase() {

    abstract fun userdao():UserDao
}
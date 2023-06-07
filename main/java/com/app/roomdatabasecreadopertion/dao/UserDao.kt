package com.app.roomdatabasecreadopertion.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.app.roomdatabasecreadopertion.model.UserData

@Dao
interface UserDao {
        @Insert
        fun inseruser(userData: UserData)
        @Query("SELECT * from user_table")
        fun getallluser():MutableList<UserData>

        @Query("select * from user_table where email = :e and password = :p LIMIT 1")
        fun checkloginuser(e:String,p:String):UserData


}
package com.app.roomdatabasecreadopertion.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserData(
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    var name:String,
    var email:String,
    var password:String,
    var comfrompassword:String,
    var gender:String,
    var dob:String
)

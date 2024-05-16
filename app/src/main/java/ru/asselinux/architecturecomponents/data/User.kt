package ru.asselinux.architecturecomponents.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
class User(
    var first_name:String,
    var last_name:String,
    var email:String,
    var password:String,
    var research_area:String,
):java.io.Serializable{
    @PrimaryKey(autoGenerate = true)
    var user_id=0
}
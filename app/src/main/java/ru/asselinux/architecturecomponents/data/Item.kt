package ru.asselinux.architecturecomponents.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "post_table")
class Item(
    var header: String,
    var preview_text:String,
    var full_text: String,
    var theme_1:String,
    var theme_2:String,
    var theme_3:String,
    val urlImage: String,
    var count_of_likes:Int,
    var count_of_readers:Int,
    var time_of_creation: String,
    var email:String,
    var author:String,
    var team_id:Int,
    var resourceLink:String,
    var resourceLink_1:String,
    var resourceLink_2:String

): Serializable {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}
package ru.asselinux.architecturecomponents.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RawQuery
import androidx.room.Update
import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.sqlite.db.SupportSQLiteQuery
import ru.asselinux.architecturecomponents.data.Item

@Dao
interface ItemDao {
    @Insert
    fun insert(item: Item)

    @Update
    fun update(item: Item)

    @Delete
    fun delete(item: Item)

    @Query("SELECT count_of_likes FROM post_table ")
    fun allLikes():LiveData<Int>

    @Query("DELETE FROM post_table")
    fun deleteAllItems()

    @Query("SELECT * FROM post_table")
    fun allItems(): LiveData<List<Item>>


    @Query("UPDATE post_table SET count_of_likes=count_of_likes+1 WHERE id IN(:id_1) ")
    fun likeIncrement(id_1:Int)

}

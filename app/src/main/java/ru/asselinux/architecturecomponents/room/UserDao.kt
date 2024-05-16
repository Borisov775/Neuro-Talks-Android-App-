package ru.asselinux.architecturecomponents.room

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.asselinux.architecturecomponents.data.Item
import ru.asselinux.architecturecomponents.data.User

@Dao
interface UserDao {
    @Insert
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM user_table where email IN(:email)")
    fun findUserByEmail(email:String):User

    @Query("SELECT * FROM user_table")
    fun allUsers(): LiveData<List<User>>

}
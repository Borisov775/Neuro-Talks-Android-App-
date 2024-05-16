package ru.asselinux.architecturecomponents.room

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import ru.asselinux.architecturecomponents.data.User
import ru.asselinux.architecturecomponents.room.ItemDatabase
import ru.asselinux.architecturecomponents.room.UserDao

class UserRepository(context: Context, scope: CoroutineScope) {
    private val userDao: UserDao
    val allUsers: LiveData<List<User>>

    init {
        val database: ItemDatabase = ItemDatabase.getDataBase(context, scope)
        userDao = database.userDao()
        allUsers = userDao.allUsers()

    }

    fun insert(user: User) {
        userDao.insert(user)
    }

    fun update(user: User) {
        userDao.update(user)
    }

    fun delete(user: User) {
        userDao.delete(user)
    }
    fun findUser(email:String):User {
        return userDao.findUserByEmail(email)
    }


}
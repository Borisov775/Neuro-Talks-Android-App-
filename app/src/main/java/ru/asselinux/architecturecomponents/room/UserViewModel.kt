package ru.asselinux.architecturecomponents.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.asselinux.architecturecomponents.data.User
import ru.asselinux.architecturecomponents.room.UserRepository

class UserViewModel(application:Application):AndroidViewModel(application) {
    private val repository = UserRepository(application.applicationContext, viewModelScope)

    val allUsers = repository.allUsers


    fun insert(user: User) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(user)
    }

    fun delete(user: User) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(user)
    }

    fun update(user: User) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(user)
    }
    fun findUser(email:String)= viewModelScope.launch(Dispatchers.IO) {
        repository.findUser(email)
    }
}
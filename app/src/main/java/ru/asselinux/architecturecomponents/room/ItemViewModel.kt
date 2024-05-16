package ru.asselinux.architecturecomponents.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.asselinux.architecturecomponents.data.Item
import ru.asselinux.architecturecomponents.room.ItemRepository

class ItemViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = ItemRepository(application.applicationContext, viewModelScope)

    val allItems = repository.allItems
    var allLikes=repository

    fun insert(item: Item) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(item)
    }

    fun delete(item: Item) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(item)
    }

    fun update(item: Item) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(item)
    }

    fun likes(item: Item)=viewModelScope.launch (Dispatchers.IO){
        repository.getLikes(item)
    }
    fun likeIncrement(item: Item)=viewModelScope.launch (Dispatchers.IO){
        repository.likeIncrement(item)
    }

}

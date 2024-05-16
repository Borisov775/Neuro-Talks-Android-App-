package ru.asselinux.architecturecomponents.room

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import ru.asselinux.architecturecomponents.data.Item
import ru.asselinux.architecturecomponents.room.ItemDao
import ru.asselinux.architecturecomponents.room.ItemDatabase

class ItemRepository(context: Context, scope: CoroutineScope) {
    private val itemDao: ItemDao
    val allItems: LiveData<List<Item>>
    var allLikes:Int=0


    fun insert(item: Item) {
        itemDao.insert(item)
    }

    fun update(item: Item) {
        itemDao.update(item)
    }

    fun delete(item: Item) {
        itemDao.delete(item)
    }
    fun getLikes(item: Item):LiveData<Int>{
        return itemDao.allLikes()
    }
    fun likeIncrement(item: Item){
        itemDao.likeIncrement(item.id)
    }
}

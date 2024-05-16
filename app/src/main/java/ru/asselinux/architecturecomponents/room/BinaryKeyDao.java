package ru.asselinux.architecturecomponents.room;

import androidx.annotation.BinderThread;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ru.asselinux.architecturecomponents.data.BinaryKey;
import ru.asselinux.architecturecomponents.data.User;

@Dao
public interface BinaryKeyDao {
    @Insert
    void insert(BinaryKey ... binaryKeys);

    @Delete
    void delete(BinaryKey ... binaryKeys);
    @Query("SELECT * FROM post_table")
    List<BinaryKey> getAllBinaryKeys();
}

package ru.asselinux.architecturecomponents.data;

import androidx.room.PrimaryKey;

import java.io.Serializable;

public class BinaryKey implements Serializable {
    String data;
    @PrimaryKey(autoGenerate = true)
    int key_id = 0;

}

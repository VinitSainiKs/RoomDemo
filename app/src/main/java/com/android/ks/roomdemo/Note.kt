package com.android.ks.roomdemo

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
class Note(id: String, note: String) {

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String = id

    @ColumnInfo(name = "note")
    var mNote: String = note

}
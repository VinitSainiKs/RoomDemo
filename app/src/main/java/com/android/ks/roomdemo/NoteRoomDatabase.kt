package com.android.ks.roomdemo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1)
abstract class NoteRoomDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile
        private var noteRoomDatabase: NoteRoomDatabase? = null

        fun getDatabase(context: Context): NoteRoomDatabase {
            return noteRoomDatabase ?: synchronized(this) {
                noteRoomDatabase = Room.databaseBuilder(
                    context.applicationContext,
                    NoteRoomDatabase::class.java,
                    "note_database"
                ).build()
                return noteRoomDatabase as NoteRoomDatabase
            }
        }
    }
}
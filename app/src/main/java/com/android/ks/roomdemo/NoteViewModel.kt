package com.android.ks.roomdemo

import android.app.Application
import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.AndroidViewModel

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    private val TAG = this.javaClass.simpleName
    var noteDao = NoteRoomDatabase.getDatabase(application).noteDao()

    fun insert(note: Note){
        InsertAsyncTask(noteDao).execute(note)
    }

    override fun onCleared() {
        super.onCleared()
        Log.i(TAG, "ViewModel Destroyed")
    }


    public class InsertAsyncTask(val mNoteDao: NoteDao) : AsyncTask<Note, Void, Void>() {
        override fun doInBackground(vararg p0: Note?): Void? {
            mNoteDao.insert(p0[0]!!)
            return null
        }
    }
}
package com.android.ks.roomdemo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val TAG = this.javaClass.simpleName
    private val NEW_NOTE_ACTIVITY_REQUEST_CODE = 1
    lateinit var noteViewModel: NoteViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)

        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val intent = Intent(this, NewNoteActivity::class.java)
            startActivityForResult(intent, NEW_NOTE_ACTIVITY_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == NEW_NOTE_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            var note_id = UUID.randomUUID().toString()
            val note = Note(note_id, data?.getStringExtra("new_note")!!)
            noteViewModel.insert(note)
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "Note Saved", Toast.LENGTH_SHORT).show()
        }
    }

}

package com.android.ks.roomdemo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_new_note.*

class NewNoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_note)

        val resultIntent: Intent? = intent

        bAdd.setOnClickListener {
            if (TextUtils.isEmpty(etNewNote.text)){
                setResult(Activity.RESULT_CANCELED, resultIntent)
            }else{
                val note: String = etNewNote.text.toString()
                resultIntent?.putExtra("new_note", note)
                setResult(Activity.RESULT_OK, resultIntent)
            }
            finish()
        }
    }
}

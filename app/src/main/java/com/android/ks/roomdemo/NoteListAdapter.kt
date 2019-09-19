package com.android.ks.roomdemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteListAdapter(val context: Context, val mNotes: List<Note>) : RecyclerView.Adapter<NoteListAdapter.NoteViewHolder>() {

//    lateinit var mNotes : List<Note>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mNotes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
            val note = mNotes.get(position)
            holder.itemView.findViewById<TextView>(R.id.txvNote).text = note.mNote
    }


    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }
}
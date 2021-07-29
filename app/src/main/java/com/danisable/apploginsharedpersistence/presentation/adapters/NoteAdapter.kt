package com.danisable.apploginsharedpersistence.presentation.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.danisable.apploginsharedpersistence.R
import com.danisable.apploginsharedpersistence.domain.model.Note
import com.danisable.apploginsharedpersistence.presentation.adapters.listener.ListenerNote
import com.danisable.apploginsharedpersistence.presentation.adapters.viewHolder.NoteViewHolders

class NoteAdapter(
    private val context: Context,
    private var notes: List<Note>,
    private val listener:ListenerNote
): RecyclerView.Adapter<NoteViewHolders>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolders {
        return NoteViewHolders(
            LayoutInflater.from(
                parent.context
            ).inflate(
                R.layout.item_note, parent, false)
        )
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: NoteViewHolders, position: Int) {
        val note = notes[position]
        holder.tvTitle.text = note.title
        holder.tvMessage.text = note.description
        holder.imgTask.setImageResource(R.drawable.ic_circle)
        holder.itemView.setOnClickListener {
            //Log.e("","${note.description}")
            listener.onClickNote(note)
        }
    }

    fun updateData(notes: List<Note>){
        this.notes = notes
        this.notifyDataSetChanged()
    }
}
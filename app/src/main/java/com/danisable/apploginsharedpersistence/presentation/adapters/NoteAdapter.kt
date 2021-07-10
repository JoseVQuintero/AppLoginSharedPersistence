package com.danisable.apploginsharedpersistence.presentation.adapters

import android.content.Context
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.danisable.apploginsharedpersistence.R
import com.danisable.apploginsharedpersistence.domain.model.Note
import com.danisable.apploginsharedpersistence.presentation.adapters.listener.ListenerNote
import com.danisable.apploginsharedpersistence.presentation.adapters.viewHolder.NoteViewHolders
import com.danisable.apploginsharedpersistence.presentation.fragment.notes.NotesFragment

class NoteAdapter(
    private val context: Context,
    private var notes: ArrayList<Note>,
    private val listener: ListenerNote
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

    fun removeArtist(position: Int){
        notes.remove(notes[position])
        notifyItemRemoved(position)
    }

    fun addArtist(){
        notes.add(Note("99",
                        "Nota 99",
                        "Task 99, for intent",
                        "08/07/2021 09:50",
                        99)
                  )
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: NoteViewHolders, position: Int) {
        val note = notes[position]
        holder.tvTitle.text = note.title
        holder.tvMessage.text = note.message
        /*if(note.category==1){
            holder.imgTask.setColorFilter(ContextCompat.getColor(context, R.color.yellow), PorterDuff.Mode.SRC_IN)
        }else{
            holder.imgTask.setColorFilter(ContextCompat.getColor(context, R.color.red), PorterDuff.Mode.SRC_IN)
        }*/
        //holder.imageAvatar.setImageResource(artist.image)
        //Glide.with(context).load(artist.image).into(holder.imageAvatar)
        holder.itemView.setOnClickListener{
            listener.onClickNote(note)
        }
    }
}
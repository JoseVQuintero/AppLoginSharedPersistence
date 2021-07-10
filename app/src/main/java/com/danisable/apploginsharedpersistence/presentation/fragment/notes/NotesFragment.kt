package com.danisable.apploginsharedpersistence.presentation.fragment.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.danisable.apploginsharedpersistence.R
import com.danisable.apploginsharedpersistence.domain.data.note.Note
import com.danisable.apploginsharedpersistence.presentation.adapters.NoteAdapter
import com.danisable.apploginsharedpersistence.presentation.adapters.listener.ListenerNote
import kotlinx.android.synthetic.main.fragment_notes.*

class NotesFragment: Fragment(),ListenerNote, View.OnClickListener {
    private lateinit var adapter: NoteAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_notes, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = NoteAdapter(requireContext(), Note.getNote(),this)

        rvNotes.setHasFixedSize(true)
        rvNotes.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        //rvArtists.layoutManager = GridLayoutManager(this,3)
        rvNotes.adapter = adapter

        fdDelete.setOnClickListener(this)
        fdAdd.setOnClickListener(this)
    }



    override fun onClick(v: View?) {

    }

    override fun onClickNote(note: com.danisable.apploginsharedpersistence.domain.model.Note) {

    }

}
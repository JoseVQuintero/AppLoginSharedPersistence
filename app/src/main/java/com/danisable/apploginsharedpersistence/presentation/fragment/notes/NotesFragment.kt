package com.danisable.apploginsharedpersistence.presentation.fragment.notes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.danisable.apploginsharedpersistence.MainActivity
import com.danisable.apploginsharedpersistence.R
import com.danisable.apploginsharedpersistence.domain.model.Note
import com.danisable.apploginsharedpersistence.presentation.adapters.NoteAdapter
import com.danisable.apploginsharedpersistence.presentation.adapters.listener.ListenerNote
import com.danisable.apploginsharedpersistence.presentation.fragment.notes.details.DetailsFragment
import kotlinx.android.synthetic.main.fragment_notes.*

class NotesFragment: Fragment(), ListenerNote, View.OnClickListener, NotesInteractor.View {

    private val notes = listOf<Note>()
    private var adapter: NoteAdapter? = null
    private var presenter: NotesPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_notes, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = NotesPresenter(requireContext(),this)

        setupAdapter()
        setupAction()
    }

    private fun setupAction(){
        fdAdd.setOnClickListener(this)
    }

    private fun setupAdapter(){
        adapter = NoteAdapter(requireContext(), notes, this)

        rvNotes.setHasFixedSize(true)
        rvNotes.layoutManager = LinearLayoutManager(requireContext())
        rvNotes.adapter = this.adapter
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.fdAdd -> {
                presenter?.createNote()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        presenter?.getNotes()
    }

    override fun onSuccess() {
        Toast.makeText(requireContext(),"Create note success",Toast.LENGTH_SHORT).show()
    }

    override fun setNotes(notes: List<Note>) {
        adapter?.updateData(notes)
        Log.e("TAG", "${notes.size}")
    }

    override fun onClickNote(note: Note) {
        val bundle = Bundle()
        bundle.putSerializable("note",note)
        (context as MainActivity).replaceFragment(DetailsFragment(),"", requireContext(), bundle)
    }
}
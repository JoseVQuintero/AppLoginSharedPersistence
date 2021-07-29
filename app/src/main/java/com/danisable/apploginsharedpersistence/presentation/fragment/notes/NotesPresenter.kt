package com.danisable.apploginsharedpersistence.presentation.fragment.notes

import android.content.Context
import com.danisable.apploginsharedpersistence.data.local.PersistenceDatabase
import com.danisable.apploginsharedpersistence.data.local.entity.NoteEntity
import java.util.*

class NotesPresenter(private val context: Context, private val view: NotesInteractor.View):NotesInteractor.Presenter {

    private val database = PersistenceDatabase(context)

    override fun createNote() {
        val id = UUID.randomUUID().toString()
        val entity = NoteEntity(id,"Titutlo prueba","Description prueba", "0",1)
        database.notesDao().createNote(entity)
        view.onSuccess()
        getNotes()
    }

    override fun getNotes() {
        val notes = database.notesDao().getNotes().map(NoteEntity::fromNoteEntity)
        view.setNotes(notes)
    }

}
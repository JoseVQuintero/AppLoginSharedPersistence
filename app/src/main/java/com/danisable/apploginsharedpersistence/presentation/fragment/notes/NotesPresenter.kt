package com.danisable.apploginsharedpersistence.presentation.fragment.public

import android.content.Context
import com.danisable.apploginsharedpersistence.domain.data.local.PersistenceDatabase
import com.danisable.apploginsharedpersistence.domain.data.local.entity.NoteEntity
import com.danisable.apploginsharedpersistence.presentation.fragment.notes.NotesInteractor
import java.util.*

class NotesPresenter(private val context: Context):NotesInteractor.Presenter {

    private val database = PersistenceDatabase(context)


    override fun createNote() {
        val id = UUID.randomUUID().toString()
        val entity = NoteEntity(id,"Titutlo prueba","Description prueba", "0",1)
        database.notesDao().createNote(entity)
    }
}
package com.danisable.apploginsharedpersistence.presentation.fragment.notes.details

import com.danisable.apploginsharedpersistence.data.local.entity.NoteEntity
import com.danisable.apploginsharedpersistence.domain.model.Note

interface DetailsInteractor {
    interface Presenter{
        fun deleteNote(note: Note)
        fun updateNote(note:Note)
    }

    interface View {
        fun onSuccess()
    }
}
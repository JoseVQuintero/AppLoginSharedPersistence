package com.danisable.apploginsharedpersistence.domain.model

import com.danisable.apploginsharedpersistence.data.local.entity.NoteEntity
import java.io.Serializable

data class Note (
    val id: String,
    var title: String,
    var description: String,
    val date: String,
    val category: Int
    ):Serializable {
        /*companion object {
            fun from(note: Note): NoteEntity {
                return NoteEntity(
                    note.id,
                    note.title,
                    note.message,
                    note.date,
                    note.category
                )
            }
        }*/
        companion object {
            fun fromNote(note: Note)
            = NoteEntity(
                    note.id,
                    note.title,
                    note.description,
                    note.date,
                    note.category
                )
        }
    }
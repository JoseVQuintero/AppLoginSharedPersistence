package com.danisable.apploginsharedpersistence.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.danisable.apploginsharedpersistence.domain.model.Note
import java.io.Serializable

@Entity(tableName = "notes")
data class NoteEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name="id") val id: String,
    @ColumnInfo(name="title") val title: String,
    @ColumnInfo(name="description") val description: String,
    @ColumnInfo(name="date") val date: String,
    @ColumnInfo(name="category") val category: Int,
): Serializable {
    companion object {
        fun fromNoteEntity(noteEntity: NoteEntity) = Note(
            noteEntity.id,
            noteEntity.title,
            noteEntity.description,
            noteEntity.date,
            noteEntity.category
            )
    }
}
package com.danisable.apploginsharedpersistence.data.local.dao

import androidx.room.*
import com.danisable.apploginsharedpersistence.data.local.entity.NoteEntity

@Dao
interface NoteDao {
    @Insert
    fun createNote(noteEntity: NoteEntity)

    @Update
    fun updateNote(noteEntity: NoteEntity)

    @Delete
    fun deleteNote(noteEntity: NoteEntity)

    @Query("select * from notes")
    fun getNotes():List<NoteEntity>

}
package com.danisable.apploginsharedpersistence.domain.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NoteEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name="id") val id: String,
    @ColumnInfo(name="title") val title: String,
    @ColumnInfo(name="description") val description: String,
    @ColumnInfo(name="date") val date: String,
    @ColumnInfo(name="category") val category: Int,
)
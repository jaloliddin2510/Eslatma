package com.example.eslatma.Options

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
    @ColumnInfo(name = "_title")
    val title: String,
    @ColumnInfo(name = "_description")
    val desc: String,
    val formattedTime: String
) {
}